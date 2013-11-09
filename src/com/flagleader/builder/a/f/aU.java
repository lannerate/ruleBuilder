package com.flagleader.builder.a.f;

import com.flagleader.builder.widget.editor.h.f;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.util.ListIterator;
import java.util.Iterator;

class aU extends f
{
  aU(aT paramaT)
  {
  }

  protected String b(String paramString)
  {
    return aT.a(this.a).getEnvionment().getVarDisplayName(paramString);
  }

  public Iterator a()
  {
    return new ListIterator(aT.a(this.a).getAllVarDisplays());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aU
 * JD-Core Version:    0.6.0
 */