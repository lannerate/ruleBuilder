package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlAttribute;
import java.util.List;

class u
  implements ChildAcceptor
{
  u(Envionment paramEnvionment, String paramString, boolean paramBoolean, List paramList)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
        if ((localIBusinessObjectEditen instanceof IPropertyObject))
        {
          if ((((localIBusinessObjectEditen instanceof AbstractExcelFieldModel)) || ((localIBusinessObjectEditen instanceof XmlAttribute)) || ((localIBusinessObjectEditen instanceof MapValue))) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
            return true;
          if (((localIBusinessObjectEditen instanceof SheetFieldModel)) || ((localIBusinessObjectEditen instanceof TreeAttribute)))
          {
            if ((this.c) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
              return true;
            if (this.d != null)
              for (int i = 0; i < this.d.size(); i++)
                if ((localIBusinessObjectEditen.getParent().equals(this.d.get(i))) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
                  return true;
            if (((localIBusinessObjectEditen instanceof TreeAttribute)) && (((TreeValueNode)localIBusinessObjectEditen.getParent()).isSingleValue()) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
              return true;
          }
        }
        else if ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b)))
        {
          return true;
        }
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    if (this.c)
      return !(paramObject instanceof IRuleTree);
    if ((this.d != null) && (this.d.size() > 0))
    {
      if ((paramObject instanceof IRuleTree))
        return false;
      if (((paramObject instanceof IWhileObject)) && (((IWhileObject)paramObject).mustWhile()))
      {
        for (int i = 0; i < this.d.size(); i++)
          if (paramObject.equals(this.d.get(i)))
            return true;
        return false;
      }
      return true;
    }
    return (!(paramObject instanceof IRuleTree)) && ((!(paramObject instanceof IWhileObject)) || (!((IWhileObject)paramObject).mustWhile()));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.u
 * JD-Core Version:    0.6.0
 */