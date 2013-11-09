package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.xml.XmlFunction;
import com.flagleader.repository.xml.XmlNode;

class W
  implements ChildAcceptor
{
  W(Envionment paramEnvionment, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if (((localIBusinessObjectEditen instanceof XmlFunction)) || ((localIBusinessObjectEditen instanceof ISubFunction)))
      {
        if ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof XmlNode)) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof XmlNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.W
 * JD-Core Version:    0.6.0
 */