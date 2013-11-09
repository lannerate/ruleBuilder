package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.u;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.xml.XmlNode;
import java.util.List;

public class p extends g
{
  public p(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Envionment)))
      return;
    Envionment localEnvionment = (Envionment)paramITreeNode;
    ValueLibrary localValueLibrary = localEnvionment.getValueLibrary();
    u localu = new u(this.a.getShell(), localEnvionment, 0);
    if (localu.open() == 0)
    {
      List localList = localu.a();
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof XmlNode))
          continue;
        XmlNode localXmlNode = (XmlNode)localList.get(i);
        String str = "";
        if (((localXmlNode.getParent() instanceof XmlNode)) && (!((XmlNode)localXmlNode.getParent()).isRootElement()))
          str = ((XmlNode)localXmlNode.getParent()).getNodeName() + localXmlNode.getNodeName();
        else
          str = localXmlNode.getNodeName();
        if ((!(localXmlNode.getParent() instanceof XmlNode)) || (localValueLibrary.getNoCaseEditen(str, localXmlNode.getDisplayName()) != null))
          continue;
        localValueLibrary.addChildElement(new MappingVariable(str, localXmlNode.getDisplayName(), "string", true));
        localValueLibrary.setModified(true);
      }
      localValueLibrary.updateViewer();
    }
  }

  public String a()
  {
    return "LoadXmlFields";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.p
 * JD-Core Version:    0.6.0
 */