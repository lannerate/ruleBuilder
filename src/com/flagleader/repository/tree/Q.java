package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.ConstantEnum;

class Q
  implements ChildAcceptor
{
  Q(Envionment paramEnvionment, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof ConstantEnum)) && (((ConstantEnum)paramObject).isEditVisible()) && ((this.b == null) || (this.b.length() == 0) || (((ConstantEnum)paramObject).getJavaType().b(this.b)));
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof EnumLibrary)) || ((paramObject instanceof EnumTable)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.Q
 * JD-Core Version:    0.6.0
 */