package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.Y;
import org.agilemore.agilegrid.an;
import org.agilemore.agilegrid.e;

public class M extends Y
{
  private p a;
  private p c;
  private p d;
  private p e;
  private p f;
  private p g;
  private p h;
  private an i;
  private an j;
  private J k;

  public M(e parame)
  {
    super(parame);
    this.i = new n(parame);
    this.a = new p(parame, 128);
    this.a.c(6144);
    this.a.a(55);
    this.c = new p(parame, 512);
    this.c.c(6144);
    this.d = new N(this, parame);
    this.d.c(6144);
    this.e = new O(this, parame);
    this.e.c(6144);
    this.j = new P(this, parame, 0);
    this.k = new J(parame);
    this.k.c(6144);
    this.f = new p(parame);
    this.f.c(2048);
    this.g = new p(parame);
    this.g.c(4096);
    this.h = new p(parame);
    this.h.c(1024);
  }

  public an a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
      return this.h;
    if ((paramInt1 == 1) && (paramInt2 == 1))
      return this.i;
    if ((paramInt1 == 0) && (paramInt2 >= 1) && (paramInt2 <= 36))
      return this.g;
    if ((paramInt2 == 0) && (paramInt1 >= 1) && (paramInt1 <= 23))
      return this.f;
    if ((paramInt1 == 24) || (paramInt2 == 37))
      return this.h;
    if ((paramInt1 >= 6) && (paramInt1 <= 23) && (paramInt2 == 15))
      return this.j;
    if ((paramInt1 >= 6) && (paramInt1 <= 23) && (paramInt2 == 17))
      return this.k;
    if (((paramInt1 == 5) && (paramInt2 >= 1) && (paramInt2 < 15)) || ((paramInt1 == 2) && (paramInt2 >= 16) && (paramInt2 <= 40)))
      return this.c;
    if ((paramInt1 >= 6) && (paramInt1 <= 23) && ((paramInt2 == 6) || (paramInt2 == 7) || (paramInt2 == 13) || (paramInt2 == 14)))
      return this.d;
    if ((paramInt1 == 6) && (paramInt2 >= 2) && (paramInt2 <= 3))
      return this.e;
    if ((paramInt1 == 7) && (((paramInt2 >= 4) && (paramInt2 <= 5)) || ((paramInt2 >= 7) && (paramInt2 <= 8))))
      return this.e;
    if ((paramInt1 == 8) && (paramInt2 >= 1) && (paramInt2 <= 4))
      return this.e;
    if ((paramInt1 == 9) && (paramInt2 >= 2) && (paramInt2 <= 5))
      return this.e;
    if ((paramInt1 == 10) && (paramInt2 >= 3) && (paramInt2 <= 5))
      return this.e;
    if ((paramInt1 == 11) && (paramInt2 >= 8) && (paramInt2 <= 9))
      return this.e;
    if ((paramInt1 == 12) && (paramInt2 >= 9) && (paramInt2 <= 11))
      return this.e;
    if ((paramInt1 == 13) && (paramInt2 >= 10) && (paramInt2 <= 12))
      return this.e;
    if ((paramInt1 == 14) && (paramInt2 >= 11) && (paramInt2 <= 12))
      return this.e;
    if ((paramInt1 == 15) && (paramInt2 >= 8) && (paramInt2 <= 12))
      return this.e;
    if ((paramInt1 == 16) && (paramInt2 >= 1) && (paramInt2 <= 5))
      return this.e;
    if ((paramInt1 == 17) && (paramInt2 >= 2) && (paramInt2 <= 5))
      return this.e;
    if ((paramInt1 == 18) && (((paramInt2 >= 3) && (paramInt2 <= 5)) || (paramInt2 == 8)))
      return this.e;
    if ((paramInt1 == 19) && (((paramInt2 >= 4) && (paramInt2 <= 5)) || ((paramInt2 >= 8) && (paramInt2 <= 9))))
      return this.e;
    if ((paramInt1 == 20) && ((paramInt2 == 5) || ((paramInt2 >= 8) && (paramInt2 <= 10))))
      return this.e;
    if ((paramInt1 == 21) && (paramInt2 >= 8) && (paramInt2 <= 11))
      return this.e;
    if ((paramInt1 == 22) && (paramInt2 >= 9) && (paramInt2 <= 12))
      return this.e;
    if ((paramInt1 == 23) && (paramInt2 >= 10) && (paramInt2 <= 12))
      return this.e;
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.M
 * JD-Core Version:    0.6.0
 */