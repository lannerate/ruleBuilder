package com.flagleader.repository.excel;

import com.flagleader.repository.IElement;
import com.flagleader.repository.d.q;
import com.flagleader.repository.rom.AbstractBOEditen;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IPropertyObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractExcelFieldModel extends AbstractBOEditen
  implements IPropertyObject
{
  private int fieldPos = 0;
  private int amountType = 0;

  public AbstractExcelFieldModel(AbstractExcelFieldModel paramAbstractExcelFieldModel)
  {
    super(paramAbstractExcelFieldModel);
    this.fieldPos = paramAbstractExcelFieldModel.fieldPos;
    this.amountType = paramAbstractExcelFieldModel.amountType;
  }

  public AbstractExcelFieldModel()
  {
  }

  public String toString()
  {
    return getDisplayName();
  }

  public String getUniqueName()
  {
    if ((getParent() != null) && ((getParent() instanceof AbstractExcelObject)))
      return ((AbstractExcelObject)getParent()).getUniqueName() + "." + getDisplayName();
    return "";
  }

  public String getVarName()
  {
    return String.valueOf(this.fieldPos);
  }

  public List getFunctions()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList;
  }

  public String getValueName()
  {
    return String.valueOf(this.fieldPos);
  }

  public void setValueName(String paramString)
  {
    this.fieldPos = Integer.parseInt(paramString);
  }

  public String getVarValue()
  {
    return getGetMethodName();
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public int getFieldPos()
  {
    return this.fieldPos;
  }

  public void setGroupName(String paramString)
  {
    super.setGroupName(paramString);
  }

  public String getShowGroupName()
  {
    if ((this.groupName == null) || (this.groupName.equals("p")))
      return getLocalString("sheetfield.text");
    return super.getShowGroupName();
  }

  public boolean hasChildField()
  {
    return getAcceptChildren(new a(this)).hasNext();
  }

  public IExcelObject getSheetTable()
  {
    if ((getParent() != null) && ((getParent() instanceof IExcelObject)))
      return (IExcelObject)getParent();
    if ((getParent() instanceof AbstractExcelFieldModel))
      return ((AbstractExcelFieldModel)getParent()).getSheetTable();
    throw new q();
  }

  public String getShowDisplayName()
  {
    if (getParent() != null)
      return getDisplayName() + "(" + getParent().getDisplayName() + ")";
    return getDisplayName();
  }

  public List getAllFields()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = localList.get(i);
      if (!(localObject instanceof AbstractExcelFieldModel))
        continue;
      localArrayList.add(localObject);
      localArrayList.addAll(((AbstractExcelFieldModel)localObject).getAllFields());
    }
    return localArrayList;
  }

  public String getSetMethodSufName()
  {
    return ")";
  }

  public boolean canSetLoged()
  {
    return false;
  }

  public String getVariableName()
  {
    return getValueName();
  }

  public boolean isLoged()
  {
    return false;
  }

  public void setLoged(boolean paramBoolean)
  {
  }

  public boolean isGroupEditable()
  {
    return true;
  }

  public boolean isTypeEditable()
  {
    return true;
  }

  public boolean isValueEditable()
  {
    return true;
  }

  public void setFieldPos(int paramInt)
  {
    this.fieldPos = paramInt;
  }

  public int getAmountType()
  {
    return this.amountType;
  }

  public void setAmountType(int paramInt)
  {
    this.amountType = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.AbstractExcelFieldModel
 * JD-Core Version:    0.6.0
 */