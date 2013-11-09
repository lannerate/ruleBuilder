package com.flagleader.repository.tree;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.MappingFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;

class Z
  implements ChildAcceptor
{
  Z(Envionment paramEnvionment)
  {
  }

  public boolean hasChildren(Object paramObject)
  {
    if ((paramObject instanceof EnumLibrary))
      return true;
    if ((paramObject instanceof ValueLibrary))
      return true;
    if ((paramObject instanceof VariableLibrary))
      return true;
    return (paramObject instanceof FunctionLibrary);
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof ConstantEnum))
      return true;
    if (((paramObject instanceof MappingVariable)) || ((paramObject instanceof TempVariable)))
      return true;
    if (((paramObject instanceof FunctionClass)) || ((paramObject instanceof MappingFunction)) || ((paramObject instanceof GlobalFunction)))
      return true;
    if (((paramObject instanceof IBusinessObjectContainer)) && ((paramObject instanceof IBusinessObject)))
      return true;
    if ((paramObject instanceof DBModel))
      return true;
    return (paramObject instanceof BOContainerGroup);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.Z
 * JD-Core Version:    0.6.0
 */