import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class QueryPattern {
 
 private String _s;
 private List<String> _vars;
 
 public QueryPattern(String s) {
  _s = s;
  _vars = parseVariables(s);
 }
 
 public List<String> variables() {
  return _vars;
 }
 
 @Override
 public String toString() {
  return _s;
 }
 
 public String evaluate(Map<String, String> varMap) throws Throwable {
  return evaluate(this, varMap);
 }
 
 public String evaluate(String[] vars) throws Throwable {
  return evaluate(this, vars);
 }
 
 public static void main(String[] args) throws Throwable {
  QueryPattern p = new QueryPattern("a \\\\\\${b} ${c}");
  System.out.println(p);
  System.out.println(p.evaluate(new String[] { "b", "1", "c", "2" }));
 }
 
 public static List<String> parseVariables(String s) {
  List<String> vars = new ArrayList<String>();
  Pattern p = Pattern.compile("\\$\\{[a-zA-Z]+\\w*\\}");
  Matcher m = p.matcher(s);
  while (m.find()) {
   int n = 0;
   for (int i = m.start()-1; i >= 0 && s.charAt(i) == '\\'; i--) {
    n++;
   }
   if (n % 2 != 0) {
    continue;
   }
   String var = s.substring(m.start() + 2, m.end() - 1);
   if (!vars.contains(var)) {
    vars.add(var);
   }
  }
  if (!vars.isEmpty()) {
   return vars;
  }
  return null;
 }
 
 public static String evaluate(QueryPattern pattern, Map<String, String> varMap) throws Throwable {
  List<String> vars = pattern.variables();
  String s = pattern.toString();
  if (vars == null) {
   return s;
  }
  for (String var : vars) {
   String value = varMap.get(var);
   if (value == null) {
    throw new Exception("Could not find value for variable: " + var);
   }
   s = s.replaceAll("\\$\\{" + var + "\\}", value);
  }
  return s;
 }
 
 public static String evaluate(String pattern, Map<String, String> varMap) throws Throwable {
  return evaluate(new QueryPattern(pattern), varMap);
 }
 
 public static String evaluate(QueryPattern pattern, String[] vars) throws Throwable {
  if (vars.length < 2 || vars.length % 2 != 0) {
   throw new Exception("Invalid length of array. Should be in the form of {\"name\", \"value\"}.");
  }
  Map<String, String> varMap = new HashMap<String, String>(vars.length / 2);
  for (int i = 0; i < vars.length; i += 2) {
   varMap.put(vars[i], vars[i + 1]);
  }
  return evaluate(pattern, varMap);
 }
 
 public static String evaluate(String pattern, String[] vars) throws Throwable {
  return evaluate(new QueryPattern(pattern), vars);
 }
}
