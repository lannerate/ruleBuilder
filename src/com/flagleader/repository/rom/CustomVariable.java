package com.flagleader.repository.rom;

import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.lang.g;

public abstract class CustomVariable extends AbstractBOEditen
  implements IVariableObject
{
  private String variableName = "";
  private boolean loged = false;

  public CustomVariable(CustomVariable paramCustomVariable)
  {
    super(paramCustomVariable);
    this.variableName = paramCustomVariable.variableName;
    this.loged = paramCustomVariable.loged;
  }

  public CustomVariable()
  {
  }

  public CustomVariable(IPropertyObject paramIPropertyObject)
  {
    this.variableName = paramIPropertyObject.getValueName();
    setVisible(paramIPropertyObject.isVisible());
    setValueType(paramIPropertyObject.getValueType());
    setDisplayName(paramIPropertyObject.getDisplayName());
  }

  public CustomVariable(FieldModel paramFieldModel)
  {
    this.variableName = paramFieldModel.getValueName();
    setVisible(paramFieldModel.isVisible());
    setValueType(paramFieldModel.getValueType());
    setDisplayName(paramFieldModel.getDisplayName());
  }

  public String getVariableName()
  {
    return this.variableName;
  }

  public void setVariableName(String paramString)
  {
    this.variableName = paramString.trim();
  }

  public boolean isTypeEditable()
  {
    return true;
  }

  public boolean isValueEditable()
  {
    return true;
  }

  public String getValueName()
  {
    return getVariableName();
  }

  public void setValueName(String paramString)
  {
    setVariableName(paramString);
  }

  public boolean canSetLoged()
  {
    return (getJavaType().b()) || (getJavaType().m()) || (getJavaType().e()) || (getJavaType().v()) || (getJavaType().w()) || (getJavaType().x()) || (getJavaType().j());
  }

  public boolean isLoged()
  {
    if (canSetLoged())
      return this.loged;
    return false;
  }

  public void setLoged(boolean paramBoolean)
  {
    this.loged = paramBoolean;
  }

  public String getVarSaveValue()
  {
    return getVarValue();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.CustomVariable
 * JD-Core Version:    0.6.0
 */