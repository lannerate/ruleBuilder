package com.flagleader.builder.widget.editor.f;

import com.flagleader.builder.widget.editor.i;
import com.flagleader.builder.widget.editor.n;
import com.flagleader.builder.widget.editor.s;

public class b extends s
{
  public b()
  {
    this.k = new c();
    this.l = new d();
  }

  public b(com.flagleader.manager.c.a parama)
  {
    super(parama);
    this.k = new c();
    if (parama == null)
      this.l = new d();
  }

  protected i a(n paramn)
  {
    return new a(paramn);
  }

  public String[] u()
  {
    return new String[] { "*.jsp", "*.do", "*.*" };
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.f.b
 * JD-Core Version:    0.6.0
 */