package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlAttribute;
import java.util.List;

class K
  implements ChildAcceptor
{
  K(Envionment paramEnvionment, boolean paramBoolean, String paramString, List paramList)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof IVariableObject))
    {
      IVariableObject localIVariableObject = (IVariableObject)paramObject;
      if ((localIVariableObject instanceof IPropertyObject))
      {
        if (((localIVariableObject instanceof SheetFieldModel)) || ((localIVariableObject instanceof TreeAttribute)))
        {
          if ((this.b) && (localIVariableObject.getDisplayName().equals(this.c)))
            return true;
          if (this.d != null)
            for (int i = 0; i < this.d.size(); i++)
              if ((localIVariableObject.getParent().equals(this.d.get(i))) && (localIVariableObject.getDisplayName().equals(this.c)))
                return true;
          if (((localIVariableObject instanceof TreeAttribute)) && (((TreeValueNode)localIVariableObject.getParent()).isSingleValue()) && (localIVariableObject.getDisplayName().equals(this.c)))
            return true;
        }
        if ((((localIVariableObject instanceof AbstractExcelFieldModel)) || ((localIVariableObject instanceof XmlAttribute)) || ((localIVariableObject instanceof MapValue))) && (localIVariableObject.getDisplayName().equals(this.c)))
          return true;
      }
      else if (localIVariableObject.getDisplayName().equals(this.c))
      {
        return true;
      }
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
 * Qualified Name:     com.flagleader.repository.tree.K
 * JD-Core Version:    0.6.0
 */