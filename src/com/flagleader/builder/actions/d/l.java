package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.o;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.ValueLibrary;
import java.util.List;

public class l extends g
{
  public l(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Envionment)))
      return;
    Envionment localEnvionment = (Envionment)paramITreeNode;
    ValueLibrary localValueLibrary = localEnvionment.getValueLibrary();
    o localo = new o(this.a.getShell(), localEnvionment, 0);
    if (localo.open() == 0)
    {
      List localList = localo.a();
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof SoapParameter))
          continue;
        SoapParameter localSoapParameter = (SoapParameter)localList.get(i);
        String str = "";
        str = localSoapParameter.getValueName();
        if ((!(localSoapParameter.getParent() instanceof SoapService)) || (localValueLibrary.getNoCaseEditen(str, localSoapParameter.getDisplayName()) != null))
          continue;
        localValueLibrary.addChildElement(new MappingVariable(str, localSoapParameter.getDisplayName(), localSoapParameter.getValueType(), true));
        localValueLibrary.setModified(true);
      }
      localValueLibrary.updateViewer();
    }
  }

  public String a()
  {
    return "LoadSoapParameters";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.l
 * JD-Core Version:    0.6.0
 */