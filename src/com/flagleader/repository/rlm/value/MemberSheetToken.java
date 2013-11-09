package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;
import java.util.List;

public class MemberSheetToken extends MemberToken
  implements IStatementToken
{
  public MemberSheetToken(MemberSheetToken paramMemberSheetToken)
  {
    super(paramMemberSheetToken);
  }

  public MemberSheetToken()
  {
  }

  public MemberSheetToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new MemberSheetToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    boolean bool = canIncludeSheetField();
    List localList = getWhileSheets();
    return getEnvionment().getAcceptElements(new h(this, bool, str, localList));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    boolean bool = canIncludeSheetField();
    List localList = getWhileSheets();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
      {
        if ((localIBusinessObjectEditen instanceof IPropertyObject))
        {
          if ((localIBusinessObjectEditen instanceof SheetFieldModel))
          {
            if ((bool) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
              return true;
            if (localList != null)
              for (int i = 0; i < localList.size(); i++)
                if ((((IWhileObject)localList.get(i)).exitsFields(localIBusinessObjectEditen)) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
                  return true;
          }
          else if ((((localIBusinessObjectEditen instanceof AbstractExcelFieldModel)) || ((localIBusinessObjectEditen instanceof MapValue))) && ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str))))
          {
            return true;
          }
        }
        else if ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof ISubFunction)) && (!(((ISubFunction)localIBusinessObjectEditen).getRootMember() instanceof DBModel)))
      {
        if (((str != null) && (str.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().d(str))))
          return true;
      }
      else if ((localIBusinessObjectEditen instanceof TableFunction))
      {
        if ((str != null) && (str.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().d(str)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof SheetTable)) && (str != null) && (str.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().d(str)))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "MemberSheetToken";
  }

  protected String i()
  {
    return getLocalString("selectSheetMember.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.MemberSheetToken
 * JD-Core Version:    0.6.0
 */