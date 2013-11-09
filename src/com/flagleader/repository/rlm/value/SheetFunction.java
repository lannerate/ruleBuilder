package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;

public class SheetFunction extends AbstractRuleObject
{
  private String funcName = "";
  private String fieldUuid = "";
  private String fieldUnique = "";
  private String asName = "";
  private transient IBusinessObject sheetField;

  public SheetFunction()
  {
  }

  public SheetFunction(String paramString1, IBusinessObject paramIBusinessObject, String paramString2)
  {
    this.funcName = paramString1;
    this.fieldUuid = paramIBusinessObject.getUuid();
    this.fieldUnique = paramIBusinessObject.getUniqueName();
    this.asName = paramString2;
    this.sheetField = paramIBusinessObject;
  }

  public SheetFunction(SheetFunction paramSheetFunction)
  {
    super(paramSheetFunction);
    this.funcName = paramSheetFunction.funcName;
    this.fieldUuid = paramSheetFunction.fieldUuid;
    this.fieldUnique = paramSheetFunction.fieldUnique;
    this.asName = paramSheetFunction.asName;
  }

  public IBusinessObject getField()
  {
    if (this.sheetField == null)
      this.sheetField = getEnvionment().getBusinessObject(getFieldUuid(), getFieldUnique());
    if (this.sheetField != null)
    {
      if (!this.sheetField.getUuid().equals(getFieldUuid()))
      {
        this.fieldUuid = this.sheetField.getUuid();
        if (getRoot() != null)
          getRoot().setNeedSave();
      }
      this.fieldUnique = this.sheetField.getUniqueName();
    }
    return this.sheetField;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetFunction(this);
  }

  public IElement deepClone()
  {
    return new SheetFunction(this);
  }

  public String getName()
  {
    return "SheetFunction";
  }

  public String getFuncName()
  {
    return this.funcName;
  }

  public String getFieldUuid()
  {
    return this.fieldUuid;
  }

  public void setFuncName(String paramString)
  {
    this.funcName = paramString;
  }

  public void setFieldUuid(String paramString)
  {
    this.fieldUuid = paramString;
  }

  public String toString()
  {
    return this.funcName + "(" + this.fieldUnique + ") as " + this.asName;
  }

  protected Object clone()
  {
    return new SheetFunction(this);
  }

  public String getAsTargetName()
  {
    if ((getParent() instanceof SheetFunctionsSelectToken))
    {
      List localList = ((SheetFunctionsSelectToken)getParent()).getAsTargetSelects();
      for (int i = 0; i < localList.size(); i++)
        if (((IBusinessObject)localList.get(i)).getDisplayName().equals(getAsName()))
          return ((IBusinessObject)localList.get(i)).getValueName();
    }
    return this.asName;
  }

  public String getAsName()
  {
    return this.asName;
  }

  public void setAsName(String paramString)
  {
    this.asName = paramString;
  }

  public String getFieldUnique()
  {
    return this.fieldUnique;
  }

  public void setFieldUnique(String paramString)
  {
    this.fieldUnique = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetFunction
 * JD-Core Version:    0.6.0
 */