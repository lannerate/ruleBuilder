package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.H;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractValueToken;
import com.flagleader.repository.rlm.editen.ISheetFieldsSelectEditen;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.ArrayList;
import java.util.List;

public class SheetFieldsSelectToken extends AbstractValueToken
  implements ISheetFieldsSelectEditen, IValueToken
{
  private String elementUuid = "";
  private String uniqueName = "";
  private String fieldUuids = "";
  private String fieldNames = "";

  public SheetFieldsSelectToken()
  {
  }

  public SheetFieldsSelectToken(SheetFieldsSelectToken paramSheetFieldsSelectToken)
  {
    super(paramSheetFieldsSelectToken);
    this.fieldUuids = paramSheetFieldsSelectToken.fieldUuids;
    this.uniqueName = paramSheetFieldsSelectToken.uniqueName;
    this.elementUuid = paramSheetFieldsSelectToken.elementUuid;
    this.fieldNames = paramSheetFieldsSelectToken.fieldNames;
  }

  public SheetFieldsSelectToken(String paramString, IBusinessObject paramIBusinessObject)
  {
    super(paramString);
    this.elementUuid = paramIBusinessObject.getUuid();
    this.uniqueName = paramIBusinessObject.getUniqueName();
  }

  public IBusinessObject getMemberElement()
  {
    IBusinessObject localIBusinessObject = null;
    if ((getElementUuid().length() > 0) || (getUniqueName().length() > 0))
      localIBusinessObject = d();
    if (localIBusinessObject != null)
    {
      if (!localIBusinessObject.getUuid().equals(getElementUuid()))
      {
        setElementUuid(localIBusinessObject.getUuid());
        if (getRoot() != null)
          getRoot().setNeedSave();
      }
      setUniqueName(localIBusinessObject.getUniqueName());
    }
    return localIBusinessObject;
  }

  protected IBusinessObject d()
  {
    IBusinessObject localIBusinessObject = null;
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
      localIBusinessObject = localEnvionment.getBusinessObject(getElementUuid(), getUniqueName());
    if ((localIBusinessObject instanceof IBusinessObject))
      return (IBusinessObject)localIBusinessObject;
    return null;
  }

  public List getSelectedElements()
  {
    String[] arrayOfString1 = this.fieldUuids.split(",");
    String[] arrayOfString2 = this.fieldNames.split(",");
    if ((arrayOfString1.length != arrayOfString2.length) || (getEnvionment() == null))
      throw new H("get selected fields error!");
    ArrayList localArrayList = new ArrayList(arrayOfString1.length);
    IBusinessObject localIBusinessObject1 = getMemberElement();
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      if (arrayOfString1[i].length() <= 0)
        continue;
      IBusinessObject localIBusinessObject2 = null;
      List localList;
      int j;
      if ((localIBusinessObject1 != null) && ((localIBusinessObject1 instanceof SheetTable)))
      {
        localList = ((SheetTable)localIBusinessObject1).getFields();
        j = 0;
      }
      while (true)
        if (((IBusinessObject)localList.get(j)).getUuid().equals(arrayOfString1[i]))
        {
          localIBusinessObject2 = (IBusinessObject)localList.get(j);
        }
        else if (((IBusinessObject)localList.get(j)).getUuid().equals(arrayOfString2[i]))
        {
          localIBusinessObject2 = (IBusinessObject)localList.get(j);
        }
        else
        {
          j++;
          if (j < localList.size())
            continue;
          break;
          if ((localIBusinessObject1 == null) || (!(localIBusinessObject1.getParent() instanceof SheetTable)))
            break;
          localList = ((SheetTable)localIBusinessObject1.getParent()).getFields();
          for (j = 0; j < localList.size(); j++)
          {
            if (((IBusinessObject)localList.get(j)).getUuid().equals(arrayOfString1[i]))
            {
              localIBusinessObject2 = (IBusinessObject)localList.get(j);
              break;
            }
            if (!((IBusinessObject)localList.get(j)).getValueName().equals(arrayOfString2[i]))
              continue;
            localIBusinessObject2 = (IBusinessObject)localList.get(j);
            break;
          }
        }
      if (localIBusinessObject2 == null)
        localIBusinessObject2 = getEnvionment().getBusinessObject(arrayOfString1[i], arrayOfString2[i]);
      if (localIBusinessObject2 == null)
        continue;
      localArrayList.add(localIBusinessObject2);
    }
    return localArrayList;
  }

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public IBusinessObject[] getSelects()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    SheetTable localSheetTable = null;
    if ((localIBusinessObject instanceof SheetTable))
      localSheetTable = (SheetTable)localIBusinessObject;
    else if ((localIBusinessObject.getParent() instanceof SheetTable))
      localSheetTable = (SheetTable)localIBusinessObject.getParent();
    if (localSheetTable != null)
    {
      List localList = localSheetTable.getFields();
      IBusinessObject[] arrayOfIBusinessObject = new IBusinessObject[localList.size()];
      for (int i = 0; i < arrayOfIBusinessObject.length; i++)
      {
        SheetFieldModel localSheetFieldModel = (SheetFieldModel)localList.get(i);
        arrayOfIBusinessObject[i] = localSheetFieldModel;
      }
      return arrayOfIBusinessObject;
    }
    return null;
  }

  public String getText()
  {
    return getDisplayName();
  }

  public boolean hasSelects()
  {
    return true;
  }

  public void setSelected(List paramList)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      IBusinessObject localIBusinessObject = (IBusinessObject)paramList.get(i);
      localStringBuffer1.append(localIBusinessObject.getUuid());
      localStringBuffer2.append(localIBusinessObject.getValueName());
      if (i == paramList.size() - 1)
        continue;
      localStringBuffer1.append(",");
      localStringBuffer2.append(",");
    }
    this.fieldUuids = localStringBuffer1.toString();
    this.fieldNames = localStringBuffer2.toString();
  }

  public void setText(String paramString)
  {
  }

  public g getJavaType()
  {
    return getTypeManager().a("string");
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetFieldsSelectToken(this);
  }

  public IElement deepClone()
  {
    return new SheetFieldsSelectToken(this);
  }

  public String getName()
  {
    return "SheetFieldsSelectToken";
  }

  public String getDisplayName()
  {
    if (getEnvionment() == null)
      return this.uniqueName;
    List localList = getSelectedElements();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < localList.size(); i++)
    {
      if (localList.get(i) == null)
        continue;
      localStringBuffer.append(((IBusinessObject)localList.get(i)).getDisplayName());
      if (i == localList.size() - 1)
        continue;
      localStringBuffer.append(" ... ");
      break;
    }
    if (localStringBuffer.length() > 0)
      return localStringBuffer.toString();
    return getLocalString("emptySelect.edit");
  }

  public boolean canEdit()
  {
    return true;
  }

  public String getColorType()
  {
    return "value";
  }

  public String getHint()
  {
    return "";
  }

  public String getNote()
  {
    String[] arrayOfString = this.fieldNames.split(",");
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      localStringBuffer.append(arrayOfString[i]);
      if (i == arrayOfString.length - 1)
        continue;
      localStringBuffer.append("\n");
    }
    return localStringBuffer.toString();
  }

  public boolean hasHint()
  {
    return false;
  }

  public String getElementUuid()
  {
    return this.elementUuid;
  }

  public void setElementUuid(String paramString)
  {
    this.elementUuid = paramString;
  }

  public String getUniqueName()
  {
    return this.uniqueName;
  }

  public void setUniqueName(String paramString)
  {
    this.uniqueName = paramString;
  }

  public String getFieldUuids()
  {
    return this.fieldUuids;
  }

  public void setFieldUuids(String paramString)
  {
    this.fieldUuids = paramString;
  }

  public String getFieldNames()
  {
    return this.fieldNames;
  }

  public void setFieldNames(String paramString)
  {
    this.fieldNames = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetFieldsSelectToken
 * JD-Core Version:    0.6.0
 */