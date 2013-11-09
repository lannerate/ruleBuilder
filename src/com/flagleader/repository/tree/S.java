package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.ConstantEnum;

class S
  implements ChildAcceptor
{
  S(Envionment paramEnvionment, String paramString1, String paramString2)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof ConstantEnum)) && (((ConstantEnum)paramObject).isEditVisible()) && (((ConstantEnum)paramObject).getGroupName().equalsIgnoreCase(this.b)) && ((this.c == null) || (this.c.length() == 0) || (((ConstantEnum)paramObject).getJavaType().b(this.c)));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof EnumLibrary)) || ((paramObject instanceof EnumTable)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.S
 * JD-Core Version:    0.6.0
 */