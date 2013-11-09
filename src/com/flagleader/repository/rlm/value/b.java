package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;

class b
  implements ChildAcceptor
{
  b(MemberDBToken paramMemberDBToken, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if (((localIBusinessObjectEditen instanceof IFunctionObject)) || ((localIBusinessObjectEditen instanceof ISubVariable)))
      {
        if (((this.b != null) && (this.b.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof ISelectObject)) && (this.b != null) && (this.b.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().c(this.b)))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof DBModel)) || ((paramObject instanceof CustomSql)) || ((paramObject instanceof ISelectObject)) || ((paramObject instanceof TableFunction)) || ((paramObject instanceof ISubFunction)) || ((paramObject instanceof ISubVariable));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.b
 * JD-Core Version:    0.6.0
 */