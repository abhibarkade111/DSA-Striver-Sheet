boolean prime[];
public void sieveOfEratosthenes(int n)
{
  prime = new boolean[n + 1];
  for (int p = 2; p * p <= n; p++) if (prime[p] == false) for (int i = p * p; i <= n; i += p) prime[i] = true;
}