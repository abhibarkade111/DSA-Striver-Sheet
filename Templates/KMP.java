
int lps[] = new int[p.length()];
for (int i = 1; i < p.length(); i++) {
  int j = lps[i - 1];
  while (j > 0 && p.charAt(i) != p.charAt(j)) {
    j = lps[j - 1];
  }
  if (p.charAt(i) == p.charAt(j))
    j++;
    if (i < p.length())
      lps[i] = j;
  }
int m = p.length();
int n = s.length();
int i = 0, j = 0;

while (i < n) {
  if (p.charAt(j) == s.charAt(i)) {
    i++;
    j++;
  }
  if (j == m) {
    return true;
    // j = lps[j-1];
  } else if (i < n && p.charAt(j) != s.charAt(i)) {
    if (j == 0) {
      i++;
    } else {
      j = lps[j - 1];
    }
  }
}
return false;

