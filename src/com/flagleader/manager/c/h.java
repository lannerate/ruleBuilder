package com.flagleader.manager.c;

import com.flagleader.manager.c.c.a;
import com.flagleader.manager.c.c.d;
import com.flagleader.manager.c.c.e;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.c.c.g;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;

public abstract class h
  implements b
{
  protected c b = null;
  protected ITreeNode c = null;
  protected r d = null;

  public h(c paramc, ITreeNode paramITreeNode, r paramr)
  {
    this.b = paramc;
    this.c = paramITreeNode;
    this.d = paramr;
    if (paramc != null)
      paramc.a(new i(this));
  }

  public ITreeNode d()
  {
    return this.c;
  }

  public r e()
  {
    return this.d;
  }

  public abstract void a();

  public f b()
  {
    return new k(this);
  }

  public void a(String paramString1, String paramString2)
  {
    this.b.a(paramString1, paramString2);
  }

  public void a(String paramString, f paramf)
  {
    this.b.a(paramString, paramf, !this.c.isLocked());
  }

  public void b(String paramString, f paramf)
  {
    this.b.b(paramString, paramf, !this.c.isLocked());
  }

  public void a(String paramString, a parama)
  {
    this.b.a(paramString, parama, !this.c.isLocked());
  }

  public void a(String paramString, com.flagleader.manager.c.c.b paramb)
  {
    this.b.a(paramString, paramb, !this.c.isLocked());
  }

  public void a(String paramString, e parame)
  {
    this.b.a(paramString, parame, !this.c.isLocked());
  }

  public void a(String paramString, g paramg)
  {
    this.b.a(paramString, paramg, !this.c.isLocked());
  }

  public void a(String paramString, com.flagleader.manager.c.c.c paramc)
  {
    this.b.a(paramString, paramc, !this.c.isLocked());
  }

  public void a(String paramString, d paramd)
  {
    this.b.a(paramString, paramd, !this.c.isLocked());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.h
 * JD-Core Version:    0.6.0
 */