package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.collections.k;
import com.flagleader.repository.rlm.lang.IVariableToken;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;
import java.util.List;

public class FieldToken extends MemberToken
  implements IVariableToken
{
  public static final String DISPLAYNAME = getLocalString("selectField.text");

  public FieldToken(FieldToken paramFieldToken)
  {
    super(paramFieldToken);
  }

  public FieldToken(String paramString)
  {
    super(paramString);
  }

  public FieldToken()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitFieldToken(this);
  }

  protected Iterator e()
  {
    if (canIncludeSheetField())
      return new k(new k(new k(new k(getEnvionment().getAssignVariables(), getEnvionment().getAllSheetVariables()), getEnvionment().getAllExcelVariables()), getEnvionment().getAllXmlVariables()), getEnvionment().getAllSoapVariables());
    List localList = getWhileSheets();
    if ((localList != null) && (localList.size() > 0))
    {
      k localk = new k(getEnvionment().getAssignVariables(), getEnvionment().getAllExcelVariables());
      for (int i = 0; i < localList.size(); i++)
        localk = new k(localk, ((IWhileObject)localList.get(i)).getFieldIterator());
      return new k(new k(localk, getEnvionment().getAllXmlVariables()), getEnvionment().getAllSoapVariables());
    }
    return new k(new k(new k(getEnvionment().getAssignVariables(), getEnvionment().getAllExcelVariables()), getEnvionment().getAllXmlVariables()), getEnvionment().getAllSoapVariables());
  }

  public IElement deepClone()
  {
    return new FieldToken(this);
  }

  public String getName()
  {
    return "FieldToken";
  }

  protected String i()
  {
    return DISPLAYNAME;
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
        return true;
      if (((localIBusinessObjectEditen instanceof IClassObject)) && (!(localIBusinessObjectEditen instanceof FunctionClass)))
        return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.FieldToken
 * JD-Core Version:    0.6.0
 */