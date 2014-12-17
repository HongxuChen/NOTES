  >>> Strengths <<<

+ Seems like a useful step toward solving a difficult problem.
+ Core idea of using slicing seems good.

          >>> Weaknesses <<<

- Technique potentially leaves a lot of work to the user to create a
 valid context.
- create a valid context
- Evaluation is somewhat unclear.
- Lots of small grammatical mistakes in writing.


          <<< Evaluation < The authors did a nice job in motivating the problem of patch>
validation and explaining the algorithm. I also think that slicing
with respect to a patch is a really interesting idea.

However, I found the paper lacking in a few ways:

* After reading the paper, the proposed technique seems to have a
 potential major weakness, and the experiments aren't solid enough to
 show that this weakness isn't important: When the code is sliced
 with respect to a patch and an error location, that results in a
 sort of "middle slice" of the program---and to symbolically execute
 that code, the state must be initialized properly to avoid both
 false positives and state explosion. Section 4.3 mentions that the
 user can provide context information to address this, but I didn't
 find that very convincing, as it can be very difficult to figure out
 what the right state should be in the middle of the
 program. Moreover, if the user knows enough to create the context,
 then why don't they just pick a function near the "beginning" of the
 patched lines, and then make its inputs (appropriately) symbolic and
 do normal symbolic execution from there?

 I think that this concern could be addressed by delving into the
 experimental results in more detail, including explicitly evaluating
 the effort to come up with the initial "middle" state.

* The experimental evaluation did not seem convincing, and it's a
 little unclear exactly what was done. Reading Section 6.2.1, I have
 the impression that patches are created by randomly picking an
 assertion, and then making some change to the program that will then
 cause the assertion to fail. The experiment is then to check whether
 the patch is identified as failing. But, why is that a good
 experiment? The authors said, "Other than the limited distance to
 assertion site, the patch site is also selected to diversify the
 rbscope to contains different code patterns as many as possible,"
 but that's not very clear. Is there evidence that most patches are
 "close by" to the assertion failures? And, exactly what changes were
 made and why are they representative?

 A much stronger expriment would be to take actual bugfix patches and
 evaluate them using Yama. There have been many versions of coreutils
 since 6.10, so this ought to be possible.

* The paper contains a lot of small grammatical errors throughout. A
 few are listed below, but the paper really needs a few more careful
 editing passes.

More comments:

* General, please use preprint mode so there are page numbers, which
 makes giving comments easier.

* p1, "We then wrap them around to achieve a path-to-path [comparison
 precision]..." I'm not sure what this means here (it only becomes
 clear a lot later).

* p1, "without taking the [contextual precondition] outside the scope"
 I'm not sure what this means here (it only becomes clear a lot later).

* p2, "overflow occurs at either line 18 or 24" - but those lines are
 assertions, not dereferences.

* p2, footnote 3, make this an URL to be parallel to the others.

* Figure 1, the gray is hard to distinguish from black when printed
 out in color.

* p3, footnote 4, I don't understand this footnote.

* Section 3.0-3.2, these sections seems excessively long given the
 core idea. As a reader, I really didn't need to see the reachability
 analysis written down in so much detail, and I certainly didn't need
 to see a correctness claim. I think it's enough to describe it in a
 few paragraphs of English text, as an optimization to make slicing
 faster.

* Section 3, it's unclear how the call graph computation works in the
 presence of function pointers?

* Algorithms 2 and 3, this algorithm does a traversal but doesn't seem
 to have any output.

* p4, "The algorithm...is sound and complete." If you're going to
 prove something (I don't think it's worth doing this, as said
 above), you need to define what soundness and completeness mean.

* Section 3.2, do you have performance numbers showing the speed
 improvement in using this initial reachability analysis to improve
 slicing performance?

* Figure 4b, lines 2 and 3 seem swapped from lines 1 and 3 in Figure
 4a. I'm not sure if that's intentional or not.

* Figure 4.1, the text doesn't quite match the figures---the text says
 that the optimization is to make only the first array element
 symbolic. But the optimization also removes the loop that iterates
 through the array. I'm also not sure what the justification for this
 is; for example, many of the bugs found by the original KLEE paper
 involve many different bytes of input strings (i.e., arrays) being
 symbolic, not just one.

* Section 6.2.1, how many runs were used to compute the performance
 numbers?

* Table 2, "number of instructions (in kilograms)" !!

* Section 6.2.1, "we adopts [sic] depth-first exploring strategy."
 Depth-first search has been identified as one of the worst possible
 strategies for symbolic execution. So, this seems like a bad idea in
 general, and makes the performance results a bit doubtful. I think
 using state of the art search strategies, but doing multiple runs to
 account for randomness, would be much better.

* "while KLEE can only detects [sic] 3 cases..." Is this data in the
 table, or is this reporting a separate experiment?

Grammar nits (p1 only):
* "and with [up to] 1,000x speedup"
* "bug-triggering inputs, [or] sometimes both"
* "all[ ]possibly using large test suites" (remove "are")
* "are called for[ ]not only[ to ]improve..."
* "with symbolic value[s], and it achieves"
* "always provide[ ]concrete inputs..."
* "because of path explo[sion]..."
* "combining the compl[e]mentary strengths"
* "to the error site,[ and ]is often relatively small[ and ]rarely..."
* "the static analysis and [slicing] steps" - bad hyphenation of "slicing"

------------------------------------

          >>> Summary of the submission <<<

The paper presents an approach named Yama for performing efficient
patch validation by performing symbolic execution on a region of
interest (rather than the whole program). The region is identified 
via slicing. When running Yama on a dozen selected patches from
Coreutils, the results indicate that the approach is quite efficient
and effective.



          >>> Strengths <<<

Important problem

Interesting idea, materialized in an implementation




          >>> Weaknesses <<<

Very poorly written paper

Paper makes strong assumptions and some unsubstantiated claims 

Approach unlikely to work on programs with large patches



          >>> Evaluation <<<

The paper addresses an important problem (patch validation) through 
an interesting idea of reducing the scope of verification to just a
region of interest. So both the motivation and the high-level
direction are compelling.

That said, after reading the paper the reader is left wondering
whether the technique really works, or the authors just got lucky with
the choice of Coreutils (a pretty stable software suite that performs
simple processing). I fail to see how the approach would scale, or work
for realistic programs. I'll point out the concrete problems next.
 


First, there is the assumption that "Yama targets bugs which manifest
themselves as runtime failures that are either assertion violations or can be
converted to assertion violations such as buffer overflow and crashes."
- In few programs you have the luxury of having assertions in the first
place. 
- When a program crashes, e.g., due to memory corruption, how would
you come up with an automatically-constructed assertion to express
that condition?


Second, the authors claim that "identification of the error site and patch site
is normally straightforward"

How is this true when there can be thousands or million instructions executed
between a piece of erroneous code to when the error manifests?
So this "Compute the minimal bounded scope" is a tall order when using
backward and forward slicing as the slices can be huge.


Third, they claim "Synthesize the validation driver. Yama then synthesizes the
validation driver, which is an executable program that wraps the
rbscope with API calls in symbolic execution engine." 

I don't really see how this works for any decent-size program, or how
this can be correct, because setting up the program state so that
patch_rbscope() can be symbolically executed correctly entails a
potentially very complicated process (program state, I/O state needs
to be set up properly).

Fourth: "Yama finds out whether the simple patches are reachable from each
other." How can Yama figure this out without an interprocedural
pointer analysis? Because two seemingly unrelated changes in two files
can be related via alisasing?

Fifth: "Note that Yama currently does not handle changes on control flow
structures, like if...else... and loops." I give credit to the authors
for acknowledging this limitation, but I would imagine that such
changes are very frequent, e.g., adding an if () guard to check for,
and handle an error case?

Sixth: "Speedup Symbolic Execution"
Frankly the techniques described here seem incorrect, and more like
stopgap measures, e.g., 
"if there are only read operations of array elements in rbscope, they
could be simulated by making a single array element" and "the same
optimization can be applied to file read operations (Figure 6), where
only the first element in reading buffer, instead of the original
file, is made symbolic, since it already represents all possible read
value."---how is that sound? 

Finally, here are the size, in lines, of the source code programs (sans the
library) from Coreutils, which the authors should point out:
cut.c   811 
factor.c  2563
join.c  1197
mv.c   512 
od.c  1923 
rm.c   356 
tail.c  2294 
tr.c  1948 
tsort.c   562 

So as a reader I am hard-pressed to believe that Coreutils programs
change in substantial ways (how many substantial bugs are there in rm, 
tr, tail, mv, programs which have been out for decades) or that the
approach works for larger/other programs.

Unsubstantiated claims:

"A patch is typically small"

A 'git log --stat' of only the source files in Coreutils indicates
that on average, a patch changes 36 lines (median 5 lines). So I kind
of buy the claim that, for Coreutils only "A patch is typically local with
respect to the
error site, is often relatively small that rarely changes core program
semantics". 
But the burden of making a convincing case as to why the patches are
small is on you the author, not the reader. And this might not hold
for other programs, especially program that change a lot---I assume
Coreutils are quite stable. 

Incorrect Claims:

"Dynamic symbolic execution is sound": no, it is not, as with all
dynamic approaches.


The quality of English writing is subpar. Here are some issues I found
on page 1 alone, after which I stopped marking grammar errors. English
problems
need to be fixed as they hamper legibility.

"static analysis that aggressively prune away" -> "static analysis that
aggressively prunes away"
"all are possibly using large test suites" -> "all possibly using large test
suites"
"conservatively warns incorrect patches" -> "conservatively warns of incorrect
patches"
"complimentary strengths" -> "complementary strengths"
"is often relatively small that rarely" -> "is often relatively small and
rarely"

