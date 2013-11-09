package com.flagleader.builder.widget.editor.j;

import com.flagleader.builder.widget.editor.r;
import com.flagleader.builder.widget.editor.s;

public class c extends s
{
  public c()
  {
    this.k = new d();
  }

  public c(com.flagleader.manager.c.a parama)
  {
    super(parama);
    this.k = new d();
    if (parama == null)
      this.l = new e();
  }

  public String[] u()
  {
    return new String[] { "*.html", "*.xml", "*.*" };
  }

  public com.flagleader.builder.widget.editor.e i()
  {
    return new a(this);
  }

  public r j()
  {
    return new b(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.j.c
 * JD-Core Version:    0.6.0
 */