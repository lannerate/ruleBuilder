package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.q;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.ValueLibrary;
import java.util.List;

public class k extends g
{
  public k(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Envionment)))
      return;
    Envionment localEnvionment = (Envionment)paramITreeNode;
    ValueLibrary localValueLibrary = localEnvionment.getValueLibrary();
    q localq = new q(this.a.getShell(), localEnvionment, 0);
    if (localq.open() == 0)
    {
      List localList = localq.a();
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof FieldModel))
          continue;
        FieldModel localFieldModel = (FieldModel)localList.get(i);
        if (localValueLibrary.exitsEditens(localFieldModel.getFieldName()) != null)
          continue;
        localValueLibrary.addChildElement(new MappingVariable(localFieldModel.getFieldName().toLowerCase(), localFieldModel.getDisplayName(), localFieldModel.getValueType(), true));
        localValueLibrary.setModified(true);
      }
      localValueLibrary.updateViewer();
    }
  }

  public String a()
  {
    return "LoadFields";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.k
 * JD-Core Version:    0.6.0
 */