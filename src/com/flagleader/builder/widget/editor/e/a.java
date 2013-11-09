package com.flagleader.builder.widget.editor.e;

import com.flagleader.builder.widget.editor.s;

public class a extends s
{
  public a()
  {
    this.k = new b();
  }

  public a(com.flagleader.manager.c.a parama)
  {
    super(parama);
    this.k = new b();
    if (parama == null)
      this.l = new c();
  }

  public String[] u()
  {
    return new String[] { "*.js", "*.html", "*.*" };
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.e.a
 * JD-Core Version:    0.6.0
 */