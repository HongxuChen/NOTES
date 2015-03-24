### Tricks

- `=(command)` expands to a tempfile with the output of command that is deleted after the line has finished.
The same as `<(command)` but allows applications to seek.

  ```bash
  evince =(zcat foo.pdf.gz)
  ```

-  `Repeat` to run a program several times:

  ```bash
  repeat 3 time sleep 1
  ```

- Use glob modifiers to sort glob expansions.

  - `(om)` sort by modification time
  - `(n)` sort numerically

  ```bash
  pdfjoin chapter*.pdf(n) -o all.pdf
  ```

