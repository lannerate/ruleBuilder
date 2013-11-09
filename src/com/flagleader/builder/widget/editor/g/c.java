package com.flagleader.builder.widget.editor.g;

import com.flagleader.builder.widget.editor.i;
import com.flagleader.builder.widget.editor.n;
import com.flagleader.builder.widget.editor.r;
import com.flagleader.builder.widget.editor.s;

public class c extends s
{
  public c()
  {
    this.k = new d();
    this.l = new e();
  }

  public c(com.flagleader.manager.c.a parama)
  {
    super(parama);
    this.k = new d();
    if (parama == null)
      this.l = new e();
  }

  protected i a(n paramn)
  {
    return new b(paramn);
  }

  public String[] u()
  {
    return new String[] { "*.rsp", "*.jsp", "*.*" };
  }

  public r j()
  {
    return new a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.g.c
 * JD-Core Version:    0.6.0
 */