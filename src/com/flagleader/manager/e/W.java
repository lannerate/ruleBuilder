package com.flagleader.manager.e;

import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d.n;
import com.flagleader.repository.h;
import com.flagleader.repository.m;

public abstract class W
  implements z, n
{
  protected int c = 0;
  protected String d = "";
  protected long e = System.currentTimeMillis();
  protected long f;
  protected Thread g = null;
  protected A h = null;
  protected IElement i = null;
  private t a = null;
  protected boolean j = false;

  public W(IElement paramIElement)
  {
    this.i = paramIElement;
  }

  public boolean i()
  {
    return this.c >= 100;
  }

  public String c()
  {
    return this.d;
  }

  public int e()
  {
    return this.c;
  }

  public long d()
  {
    return this.e;
  }

  public void f()
  {
    if ((this.c < 100) && (this.g != null) && (this.g.isAlive()))
    {
      this.j = true;
      this.g.stop();
      this.c = 100;
      j();
    }
  }

  private void j()
  {
    if (this.h != null)
      this.h.a(this);
  }

  public void g()
  {
    if (!this.g.isAlive())
    {
      this.e = System.currentTimeMillis();
      this.d = "";
      a(1);
      this.g.start();
    }
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
    j();
  }

  public void b(String paramString)
  {
    this.d = (this.d + paramString + "\n");
    j();
  }

  public IElement h()
  {
    return this.i;
  }

  public void a(A paramA)
  {
    this.h = paramA;
  }

  public t n()
  {
    return this.a;
  }

  public void a(t paramt)
  {
    this.a = paramt;
  }

  protected h o()
  {
    if (n() != null)
      return n().a().j();
    return m.a().j();
  }

  public long p()
  {
    return this.f;
  }

  public String b()
  {
    return h().getUuid() + getClass().getName();
  }

  public Thread q()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.W
 * JD-Core Version:    0.6.0
 */