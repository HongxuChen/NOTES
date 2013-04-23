// http://en.wikipedia.org/wiki/Julian_day

#include <iostream>

float getJulianDay(int year, int month, int day){
  int a = (14 - month)/12;
  int y = year+4800-a;
  int m = month+12*a-3;

  return (float)day+(float)(153*m+2)+365*y+(float)y/4-32083;
}

void GetGregorianDay(float jd, int *year, int *month, int *day){
  int y = 4716;
  int j = 1401;
  int m = 2;
  int n = 12;
  int r = 4;
  int p = 1461;
  int v = 3;
  int u = 5;
  int s = 153;
  int w = 2;
  float f = jd+j;
  long e = r*f+v;
  int g = e%p;
  g /= r;
  int h = u*g+w;
  *day = h%s;
  *day /= u;
  *month = (h/s+m)%n;
  *month += 1;
  *year = e/p-y+(n+m-*month)/n;
}

int main(int argc, char *argv[])
{
  int y1 = 2011;
  int y2 = 2013;
  int m1 = 4;
  int m2 = 4;
  int d1 = 23;
  int d2 = 25;
  float j1 = getJulianDay(y1, m1, d1);
  float j2 = getJulianDay(y2, m2, d2);
  std::cout << j2-j1 << std::endl;
  // float j3 = j2+4;
  GetGregorianDay(j2, &y2, &m2, &d2);
  std::cout << y2<<"/"<<m2<<"/"<<d2 << std::endl;
  return 0;
}
