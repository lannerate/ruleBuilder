package com.flagleader.builder.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.c.a.bj;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.XmlNode;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class y extends k
{
  bj a = null;

  public y(XmlNode paramXmlNode, Composite paramComposite, bu parambu)
  {
    super(paramXmlNode, paramComposite, parambu);
    this.a = new bj(this, paramXmlNode, parambu.i().getRulesManager());
  }

  protected void a(Table paramTable)
  {
    this.a.a();
  }

  public String getCompositeUuid()
  {
    return d().getEditUuid() + "props1";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.y
 * JD-Core Version:    0.6.0
 */