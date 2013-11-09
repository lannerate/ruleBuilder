package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.xml.TreeFunction;
import com.flagleader.repository.xml.TreeValueNode;

class X
  implements ChildAcceptor
{
  X(Envionment paramEnvionment, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if (((localIBusinessObjectEditen instanceof TreeFunction)) || ((localIBusinessObjectEditen instanceof ISubFunction)))
      {
        if ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof TreeValueNode)) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.X
 * JD-Core Version:    0.6.0
 */