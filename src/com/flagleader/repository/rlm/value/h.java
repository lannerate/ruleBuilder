package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.BOContainerGroup;
import java.util.List;

class h
  implements ChildAcceptor
{
  h(MemberSheetToken paramMemberSheetToken, boolean paramBoolean, String paramString, List paramList)
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
                if ((((IWhileObject)this.d.get(i)).exitsFields(localIBusinessObjectEditen)) && ((this.c == null) || (this.c.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.c))))
                  return true;
          }
          else if ((((localIBusinessObjectEditen instanceof AbstractExcelFieldModel)) || ((localIBusinessObjectEditen instanceof MapValue))) && ((this.c == null) || (this.c.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.c))))
          {
            return true;
          }
        }
        else if ((this.c == null) || (this.c.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.c)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof ISubFunction)) && (!(((ISubFunction)localIBusinessObjectEditen).getRootMember() instanceof DBModel)))
      {
        if (((this.c != null) && (this.c.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().c(this.c))))
          return true;
      }
      else if ((localIBusinessObjectEditen instanceof TableFunction))
      {
        if ((this.c != null) && (this.c.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().c(this.c)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof SheetTable)) && (this.c != null) && (this.c.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().c(this.c)))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof SheetTable)) || ((paramObject instanceof TableFunction)) || ((paramObject instanceof ISubFunction)) || ((paramObject instanceof IPropertyObject)) || ((paramObject instanceof ISubVariable)) || ((paramObject instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.h
 * JD-Core Version:    0.6.0
 */