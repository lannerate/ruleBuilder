package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.xml.XmlAttribute;
import java.util.List;

class t
  implements ChildAcceptor
{
  t(Envionment paramEnvionment, boolean paramBoolean, String paramString, List paramList)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
      {
        if ((localIBusinessObjectEditen instanceof IPropertyObject))
        {
          if ((localIBusinessObjectEditen instanceof SheetFieldModel))
          {
            if ((this.b) && ((this.c == null) || (this.c.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.c))))
              return true;
            if (this.d != null)
              for (int i = 0; i < this.d.size(); i++)
                if ((localIBusinessObjectEditen.getParent().equals(this.d.get(i))) && ((this.c == null) || (this.c.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.c))))
                  return true;
          }
          else if ((((localIBusinessObjectEditen instanceof AbstractExcelFieldModel)) || ((localIBusinessObjectEditen instanceof XmlAttribute)) || ((localIBusinessObjectEditen instanceof MapValue))) && ((this.c == null) || (this.c.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.c))))
          {
            return true;
          }
        }
        else if ((this.c == null) || (this.c.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.c)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof IClassObject)) && (!(localIBusinessObjectEditen instanceof FunctionClass)))
      {
        if ((this.c == null) || (this.c.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.c)))
          return true;
      }
      else if ((localIBusinessObjectEditen instanceof IFunctionObject))
      {
        if (((this.c != null) && (this.c.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().c(this.c))))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof IBOAndContainer)) && (this.c != null) && (this.c.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().c(this.c)))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    if (this.b)
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
 * Qualified Name:     com.flagleader.repository.tree.t
 * JD-Core Version:    0.6.0
 */