package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractBOToken;
import com.flagleader.repository.rlm.ElementTextToken;
import com.flagleader.repository.rlm.StaticTextToken;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class MemberToken extends AbstractBOToken
  implements IMultiEditen, IValueToken
{
  public static final String DISPLAYNAME = getLocalString("selectMember.text");

  public MemberToken(MemberToken paramMemberToken)
  {
    super(paramMemberToken);
  }

  public MemberToken()
  {
  }

  public MemberToken(String paramString)
  {
    super(paramString);
  }

  public String getDisplayName()
  {
    String str = super.getDisplayName();
    if ((str != null) && (str.length() > 0))
      return str;
    return i();
  }

  protected String i()
  {
    return DISPLAYNAME;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitMemberToken(this);
  }

  protected Iterator e()
  {
    return getEnvionment().getValueMembers(getValueType(), canIncludeSheetField(), getWhileSheets());
  }

  public IElement deepClone()
  {
    return new MemberToken(this);
  }

  public String getName()
  {
    return "MemberToken";
  }

  public void setMemberElement(IElement paramIElement)
  {
    super.setMemberElement(paramIElement);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramIElement instanceof IBusinessObject))
    {
      localObject = ((IBusinessObject)paramIElement).getAllParams().iterator();
      while (((Iterator)localObject).hasNext())
      {
        MethodParam localMethodParam = (MethodParam)((Iterator)localObject).next();
        if (localMethodParam.hasDefaultValue())
          continue;
        localArrayList.add(localMethodParam);
      }
    }
    if (((paramIElement instanceof IBusinessObject)) && (localArrayList.size() > 0))
    {
      localObject = new MethodParam[localArrayList.size()];
      for (int i = 0; i < localArrayList.size(); i++)
        localObject[i] = ((MethodParam)localArrayList.get(i));
      clearAllChildren();
      i = 0;
      String str1 = paramIElement.getDisplayName();
      int j = 0;
      StringTokenizer localStringTokenizer = new StringTokenizer(str1.substring(str1.indexOf("{") + 1), "{");
      while (localStringTokenizer.hasMoreTokens())
      {
        String str2 = localStringTokenizer.nextToken().trim();
        if (str2.indexOf("}") >= 0)
        {
          String str3 = str2.substring(0, str2.indexOf("}"));
          int k = b(str3);
          int m = 0;
          for (int n = 0; n < localObject.length; n++)
          {
            if (!localObject[n].getParamName().equalsIgnoreCase("arg" + k))
              continue;
            addChildElement(new ValueToken(1, localObject[n].getTypeName(), "arg" + k, (IBusinessObject)paramIElement));
            m = 1;
            break;
          }
          if (m == 0)
            if ((k > 0) && (k <= localObject.length))
              addChildElement(new ValueToken(1, localObject[(k - 1)].getTypeName(), "arg" + k, (IBusinessObject)paramIElement));
            else if (i < localObject.length)
              addChildElement(new ValueToken(1, localObject[(i++)].getTypeName(), "arg" + i, (IBusinessObject)paramIElement));
          if (str2.substring(str2.indexOf("}") + 1).length() > 0)
            addChildElement(new ElementTextToken(str2.substring(str2.indexOf("}") + 1), getColorType(), j++, getElementUuid(), getUniqueName()));
          else
            j++;
        }
        else if (str2.length() > 0)
        {
          addChildElement(new ElementTextToken(str2, getColorType(), j++, getElementUuid(), getUniqueName()));
        }
        else
        {
          j++;
        }
      }
    }
    else
    {
      a().clear();
    }
  }

  public g getParamType(String paramString)
  {
    MethodParam[] arrayOfMethodParam = getMethodParams();
    if ((b(paramString) > 0) && (b(paramString) <= arrayOfMethodParam.length))
      return getTypeManager().a(arrayOfMethodParam[(b(paramString) - 1)].getTypeName());
    return null;
  }

  private MemberToken.MemberSelector j()
  {
    String str = getDisplayName();
    int i = str.indexOf("{");
    if (i < 0)
      return new MemberToken.MemberSelector(this, getDisplayName());
    if (i == 0)
      return new MemberToken.MemberSelector(this, "  ");
    return new MemberToken.MemberSelector(this, str.substring(0, i));
  }

  private int b(String paramString)
  {
    String str = "";
    for (int i = 0; i < paramString.length(); i++)
      switch (paramString.charAt(i))
      {
      case '0':
        str = str + '0';
        break;
      case '1':
        str = str + '1';
        break;
      case '2':
        str = str + '2';
        break;
      case '3':
        str = str + '3';
        break;
      case '4':
        str = str + '4';
        break;
      case '5':
        str = str + '5';
        break;
      case '6':
        str = str + '6';
        break;
      case '7':
        str = str + '7';
        break;
      case '8':
        str = str + '8';
        break;
      case '9':
        str = str + '9';
      }
    try
    {
      if (str.length() == 0)
        return 0;
      return Integer.parseInt(str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  public int getParamCount()
  {
    IElement localIElement = getMemberElement();
    if ((localIElement != null) && ((localIElement instanceof IBusinessObject)))
      return ((IBusinessObject)localIElement).getAllParams().size();
    return 0;
  }

  public MethodParam[] getMethodParams()
  {
    MethodParam[] arrayOfMethodParam = new MethodParam[getParamCount()];
    int i = 0;
    IElement localIElement = getMemberElement();
    if (localIElement != null)
    {
      Iterator localIterator = ((IBusinessObject)localIElement).getAllParams().iterator();
      while (localIterator.hasNext())
        arrayOfMethodParam[(i++)] = ((MethodParam)localIterator.next());
    }
    return arrayOfMethodParam;
  }

  public boolean checkParams()
  {
    IElement localIElement = getMemberElement();
    if ((localIElement == null) || (!(localIElement instanceof IBusinessObject)))
      return false;
    List localList = ((IBusinessObject)localIElement).getAllParams();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof MethodParam)) && (!((MethodParam)localList.get(i)).hasDefaultValue()) && (getDisplayName().indexOf(((MethodParam)localList.get(i)).getParamName()) < 0))
        return false;
    return true;
  }

  public void setValueToken(ValueToken paramValueToken)
  {
    addChildElement(paramValueToken);
  }

  public List getValueTokens()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof ValueToken))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public ValueToken getValueToken(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ValueToken)) && (((ValueToken)localObject).getArgName().equals(paramString)))
        return (ValueToken)localObject;
    }
    return null;
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList1 = new ArrayList();
    IBusinessObject localIBusinessObject = (IBusinessObject)getMemberElement();
    if ((localIBusinessObject instanceof IPropertyObject))
    {
      localArrayList1.add(j());
    }
    else
    {
      localArrayList1.add(j());
      ArrayList localArrayList2 = new ArrayList();
      Object localObject1;
      if (localIBusinessObject != null)
      {
        a(localIBusinessObject.getAllParams().size());
        localObject1 = localIBusinessObject.getAllParams().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          MethodParam localMethodParam = (MethodParam)((Iterator)localObject1).next();
          if (localMethodParam.hasDefaultValue())
            continue;
          localArrayList2.add(localMethodParam);
        }
      }
      if ((localIBusinessObject != null) && (localArrayList2.size() > 0))
      {
        localObject1 = new MethodParam[localArrayList2.size()];
        for (int i = 0; i < localArrayList2.size(); i++)
          localObject1[i] = ((MethodParam)localArrayList2.get(i));
        String str1 = localIBusinessObject.getDisplayName();
        int j = 0;
        StringTokenizer localStringTokenizer = new StringTokenizer(str1.substring(str1.indexOf("{") + 1), "{");
        while (localStringTokenizer.hasMoreTokens())
        {
          String str2 = localStringTokenizer.nextToken().trim();
          if (str2.indexOf("}") >= 0)
          {
            String str3 = str2.substring(0, str2.indexOf("}"));
            int k = b(str3);
            Object localObject2 = null;
            for (int m = 0; m < localObject1.length; m++)
            {
              if (!localObject1[m].getParamName().equalsIgnoreCase("arg" + k))
                continue;
              localObject2 = localObject1[m];
              break;
            }
            if ((localObject2 == null) && (k > 0) && (k <= localObject1.length))
              localObject2 = localObject1[(k - 1)];
            if (localObject2 != null)
            {
              if (getValueToken("arg" + k) == null)
                addChildElement(new ValueToken(1, localObject2.getTypeName(), "arg" + k, localIBusinessObject));
              ValueToken localValueToken = getValueToken("arg" + k);
              if (((localIBusinessObject.getParent() instanceof SelectTable)) && (localIBusinessObject.getValueName().equals("selectWhere")))
                localValueToken.setNote(((SelectTable)localIBusinessObject.getParent()).getParamDisplay("arg" + k));
              else if ((localIBusinessObject.getParent() instanceof CustomSql))
                localValueToken.setNote(((CustomSql)localIBusinessObject.getParent()).getParamDisplay("arg" + k));
              else if (((localIBusinessObject.getParent() instanceof SheetTable)) && (localIBusinessObject.getValueName().equals("loadFromSql")))
                localValueToken.setNote(((SheetTable)localIBusinessObject.getParent()).getParamDisplay("arg" + k));
              localArrayList1.add(localValueToken);
            }
            if (str2.substring(str2.indexOf("}") + 1).length() > 0)
              localArrayList1.add(new ElementTextToken(str2.substring(str2.indexOf("}") + 1), getColorType(), j++, getElementUuid(), getUniqueName()));
            else
              j++;
          }
          else if (str2.length() > 0)
          {
            localArrayList1.add(new ElementTextToken(str2, getColorType(), j++, getElementUuid(), getUniqueName()));
          }
          else
          {
            j++;
          }
        }
      }
      else
      {
        localArrayList1.addAll(a());
      }
    }
    return (Iterator)localArrayList1.iterator();
  }

  private void a(int paramInt)
  {
    List localList = getValueTokens();
    for (int i = 0; i < localList.size(); i++)
    {
      if (b(((ValueToken)localList.get(i)).getArgName()) <= paramInt)
        continue;
      ((ValueToken)localList.get(i)).dispose();
    }
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof MemberToken.MemberSelector)) || ((paramIElement instanceof ValueToken)) || ((paramIElement instanceof StaticTextToken)) || ((paramIElement instanceof ElementTextToken));
  }

  public void addChildElement(IElement paramIElement)
  {
    super.addChildElement(paramIElement);
  }

  private MemberToken.MemberSelector k()
  {
    String str = getDisplayName();
    int i = str.indexOf("{");
    if (i < 0)
      return new MemberToken.MemberSelector(this, getDisplayName());
    if (i == 0)
      return new MemberToken.MemberSelector(this, "  ");
    return new MemberToken.MemberSelector(this, str.substring(0, i + 1));
  }

  public Iterator getToStringToken()
  {
    ArrayList localArrayList1 = new ArrayList();
    IBusinessObject localIBusinessObject = (IBusinessObject)getMemberElement();
    if ((localIBusinessObject instanceof IPropertyObject))
    {
      localArrayList1.add(j());
    }
    else
    {
      localArrayList1.add(k());
      ArrayList localArrayList2 = new ArrayList();
      Object localObject1;
      if (localIBusinessObject != null)
      {
        a(localIBusinessObject.getAllParams().size());
        localObject1 = localIBusinessObject.getAllParams().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          MethodParam localMethodParam = (MethodParam)((Iterator)localObject1).next();
          if (localMethodParam.hasDefaultValue())
            continue;
          localArrayList2.add(localMethodParam);
        }
      }
      if ((localIBusinessObject != null) && (localArrayList2.size() > 0))
      {
        localObject1 = new MethodParam[localArrayList2.size()];
        for (int i = 0; i < localArrayList2.size(); i++)
          localObject1[i] = ((MethodParam)localArrayList2.get(i));
        String str1 = localIBusinessObject.getDisplayName();
        int j = 0;
        StringTokenizer localStringTokenizer = new StringTokenizer(str1.substring(str1.indexOf("{") + 1), "{");
        boolean bool = localStringTokenizer.hasMoreTokens();
        while (bool)
        {
          String str2 = localStringTokenizer.nextToken().trim();
          bool = localStringTokenizer.hasMoreTokens();
          if (str2.indexOf("}") >= 0)
          {
            String str3 = str2.substring(0, str2.indexOf("}"));
            int k = b(str3);
            Object localObject2 = null;
            for (int m = 0; m < localObject1.length; m++)
            {
              if (!localObject1[m].getParamName().equalsIgnoreCase("arg" + k))
                continue;
              localObject2 = localObject1[m];
              break;
            }
            if ((localObject2 == null) && (k > 0) && (k <= localObject1.length))
              localObject2 = localObject1[(k - 1)];
            if (localObject2 != null)
            {
              if (getValueToken("arg" + k) == null)
                addChildElement(new ValueToken(1, localObject2.getTypeName(), "arg" + k, localIBusinessObject));
              ValueToken localValueToken = getValueToken("arg" + k);
              if (((localIBusinessObject.getParent() instanceof SelectTable)) && (localIBusinessObject.getValueName().equals("selectWhere")))
                localValueToken.setNote(((SelectTable)localIBusinessObject.getParent()).getParamDisplay("arg" + k));
              else if ((localIBusinessObject.getParent() instanceof CustomSql))
                localValueToken.setNote(((CustomSql)localIBusinessObject.getParent()).getParamDisplay("arg" + k));
              else if (((localIBusinessObject.getParent() instanceof SheetTable)) && (localIBusinessObject.getValueName().equals("loadFromSql")))
                localValueToken.setNote(((SheetTable)localIBusinessObject.getParent()).getParamDisplay("arg" + k));
              localArrayList1.add(localValueToken);
            }
            if (str2.substring(str2.indexOf("}")).length() > 0)
              localArrayList1.add(new ElementTextToken(str2.substring(str2.indexOf("}")), getColorType(), j++, getElementUuid(), getUniqueName()));
            else
              j++;
          }
          else if (str2.length() > 0)
          {
            if (bool)
              localArrayList1.add(new ElementTextToken(str2 + "{", getColorType(), j++, getElementUuid(), getUniqueName()));
            else
              localArrayList1.add(new ElementTextToken(str2, getColorType(), j++, getElementUuid(), getUniqueName()));
          }
          else
          {
            j++;
          }
        }
      }
      else
      {
        localArrayList1.addAll(a());
      }
    }
    return (Iterator)localArrayList1.iterator();
  }

  public String toString()
  {
    Iterator localIterator = getToStringToken();
    StringBuffer localStringBuffer = new StringBuffer();
    while (localIterator.hasNext())
      localStringBuffer.append(localIterator.next());
    return localStringBuffer.toString();
  }

  public boolean canIncludeSheetField()
  {
    if (getRoot() != null)
    {
      IPackageElement localIPackageElement = getRoot().getRuleTree();
      if ((localIPackageElement instanceof IRuleTree))
        return ((IRuleTree)localIPackageElement).canIncludeSheet();
    }
    return false;
  }

  public List getWhileSheets()
  {
    if (getRoot() != null)
    {
      IPackageElement localIPackageElement = getRoot().getRuleTree();
      if (((localIPackageElement instanceof IRuleTree)) && (((IRuleTree)localIPackageElement).hasSheetWhile()))
        return ((IRuleTree)localIPackageElement).getAllWhileSheets();
    }
    return null;
  }

  public boolean acceptSheetField(SheetFieldModel paramSheetFieldModel)
  {
    if (canIncludeSheetField())
      return true;
    if (paramSheetFieldModel.getParent() != null)
    {
      List localList = getWhileSheets();
      if (localList != null)
        for (int i = 0; i < localList.size(); i++)
          if (paramSheetFieldModel.getParent().equals(localList.get(i)))
            return true;
    }
    return false;
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    boolean bool = canIncludeSheetField();
    List localList = getWhileSheets();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
      {
        if ((localIBusinessObjectEditen instanceof IPropertyObject))
        {
          if (((localIBusinessObjectEditen instanceof SheetFieldModel)) || ((localIBusinessObjectEditen instanceof TreeAttribute)))
          {
            if ((bool) && ((getValueType() == null) || (getValueType().length() == 0) || (localIBusinessObjectEditen.getJavaType().d(getValueType()))))
              return true;
            if (localList != null)
              for (int i = 0; i < localList.size(); i++)
                if ((((IWhileObject)localList.get(i)).exitsFields(localIBusinessObjectEditen)) && ((getValueType() == null) || (getValueType().length() == 0) || (localIBusinessObjectEditen.getJavaType().d(getValueType()))))
                  return true;
          }
          else if ((((localIBusinessObjectEditen instanceof AbstractExcelFieldModel)) || ((localIBusinessObjectEditen instanceof XmlAttribute)) || ((localIBusinessObjectEditen instanceof MapValue))) && ((getValueType() == null) || (getValueType().length() == 0) || (localIBusinessObjectEditen.getJavaType().d(getValueType()))))
          {
            return true;
          }
          if ((localIBusinessObjectEditen instanceof TreeAttribute))
          {
            Iterator localIterator = getEnvionment().getAcceptElements(new k(this));
            while (localIterator.hasNext())
            {
              TreeValueNode localTreeValueNode = (TreeValueNode)localIterator.next();
              if ((localTreeValueNode.isSingleValue()) && (localTreeValueNode.exitsFields(localIBusinessObjectEditen)) && ((getValueType() == null) || (getValueType().length() == 0) || (localIBusinessObjectEditen.getJavaType().d(getValueType()))))
                return true;
            }
          }
        }
        else if ((getValueType() == null) || (getValueType().length() == 0) || (localIBusinessObjectEditen.getJavaType().d(getValueType())))
        {
          return true;
        }
      }
      else if (((localIBusinessObjectEditen instanceof IClassObject)) && (!(localIBusinessObjectEditen instanceof FunctionClass)))
      {
        if ((getValueType() == null) || (getValueType().length() == 0) || (localIBusinessObjectEditen.getJavaType().d(getValueType())))
          return true;
      }
      else if ((localIBusinessObjectEditen instanceof IFunctionObject))
      {
        if (((getValueType() != null) && (getValueType().length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().d(getValueType()))))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof IBOAndContainer)) && (getValueType() != null) && (getValueType().length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().d(getValueType())))
        return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.MemberToken
 * JD-Core Version:    0.6.0
 */