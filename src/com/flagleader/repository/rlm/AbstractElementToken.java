package com.flagleader.repository.rlm;

import com.flagleader.repository.ElementList;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.c.h;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.PackageFieldSet;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.BusinessObjectConstructor;
import com.flagleader.repository.rom.BusinessObjectMethod;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.FunctionMember;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.MappingFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlAttribute;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.StringUtil;
import com.flagleader.util.exception.UnsupportOperationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractElementToken extends AbstractRuleObject
{
  private String elementUuid = "";
  protected transient List a = new ArrayList(1);
  private String uniqueName = "";
  protected ArrayList b = null;
  IElement c = null;
  protected long d = 0L;

  public AbstractElementToken()
  {
  }

  public AbstractElementToken(AbstractElementToken paramAbstractElementToken)
  {
    super(paramAbstractElementToken);
    this.elementUuid = paramAbstractElementToken.elementUuid;
    this.uniqueName = paramAbstractElementToken.uniqueName;
    this.d = paramAbstractElementToken.d;
  }

  public l[] getLeftPopupMenus()
  {
    List localList = null;
    localList = a(e());
    ArrayList localArrayList = new ArrayList(localList.size());
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof ElementList))
      {
        ElementList localElementList = (ElementList)localList.get(i);
        if (localElementList.size() <= 0)
          continue;
        l locall = new l(localElementList.getDisplayName(), new b(this, localElementList.getElement()), localElementList.getElement());
        localArrayList.add(locall);
        a(locall, localElementList);
      }
      else
      {
        localArrayList.add(new l(((IElement)localList.get(i)).getDisplayName(), new b(this, (IElement)localList.get(i)), (IElement)localList.get(i)));
      }
    l[] arrayOfl = new l[localArrayList.size()];
    for (i = 0; i < localArrayList.size(); i++)
      arrayOfl[i] = ((l)localArrayList.get(i));
    return arrayOfl;
  }

  protected List a(Iterator paramIterator)
  {
    if (this.b == null)
      this.b = new ArrayList();
    else
      this.b.clear();
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      if (((IBusinessObjectEditen)localObject).getContainer() == null)
      {
        if (!StringUtil.isEmpty(((IBusinessObjectEditen)localObject).getShowGroupName()))
          a(((IBusinessObjectEditen)localObject).getShowGroupName()).add((IBusinessObjectEditen)localObject);
        else
          this.b.add(localObject);
      }
      else
        a((IBusinessObjectEditen)localObject);
    }
    for (int i = 0; i < this.b.size(); i++)
    {
      if ((!(this.b.get(i) instanceof ElementList)) || (((ElementList)this.b.get(i)).getElement() == null))
        continue;
      a((ElementList)this.b.get(i));
    }
    return this.b;
  }

  private void a(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    a(paramIBusinessObjectEditen.getContainer()).add(paramIBusinessObjectEditen);
  }

  protected ElementList a(String paramString)
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      if (((this.b.get(j) instanceof ElementList)) && (((ElementList)this.b.get(j)).getElement() == null) && (((ElementList)this.b.get(j)).getDisplayName().equals(paramString)))
        return (ElementList)this.b.get(j);
    ElementList localElementList = new ElementList(paramString);
    this.b.add(localElementList);
    return localElementList;
  }

  protected ElementList a(IBusinessObjectContainer paramIBusinessObjectContainer)
  {
    Object localObject1;
    Object localObject2;
    ElementList localElementList2;
    if ((paramIBusinessObjectContainer instanceof TreeValueNode))
    {
      localObject1 = (TreeValueNode)paramIBusinessObjectContainer;
      if (!((TreeValueNode)localObject1).isRootElement())
      {
        localObject2 = ((TreeValueNode)localObject1).getRootElement();
        localElementList2 = a((IBusinessObjectContainer)localObject2);
        for (int k = 0; k < localElementList2.size(); k++)
          if (((localElementList2.get(k) instanceof ElementList)) && (((ElementList)localElementList2.get(k)).getElement() != null) && (((ElementList)localElementList2.get(k)).getElement().equals(paramIBusinessObjectContainer)))
            return (ElementList)localElementList2.get(k);
        ElementList localElementList3 = new ElementList(paramIBusinessObjectContainer);
        localElementList2.add(localElementList3);
        return localElementList3;
      }
    }
    else if ((paramIBusinessObjectContainer instanceof XmlNode))
    {
      localObject1 = (XmlNode)paramIBusinessObjectContainer;
      if (!((XmlNode)localObject1).isRootElement())
      {
        localObject2 = ((XmlNode)localObject1).getRootElement();
        localElementList2 = a((IBusinessObjectContainer)localObject2);
        for (int m = 0; m < localElementList2.size(); m++)
          if (((localElementList2.get(m) instanceof ElementList)) && (((ElementList)localElementList2.get(m)).getElement() != null) && (((ElementList)localElementList2.get(m)).getElement().equals(paramIBusinessObjectContainer)))
            return (ElementList)localElementList2.get(m);
        ElementList localElementList4 = new ElementList(paramIBusinessObjectContainer);
        localElementList2.add(localElementList4);
        return localElementList4;
      }
    }
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      if (((this.b.get(j) instanceof ElementList)) && (((ElementList)this.b.get(j)).getElement() != null) && (((ElementList)this.b.get(j)).getElement().equals(paramIBusinessObjectContainer)))
        return (ElementList)this.b.get(j);
    ElementList localElementList1 = new ElementList(paramIBusinessObjectContainer);
    this.b.add(localElementList1);
    return (ElementList)(ElementList)localElementList1;
  }

  private int a(ElementList paramElementList, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    int i = 0;
    for (int j = 0; j < paramElementList.size(); j++)
    {
      if ((!(paramElementList.get(j) instanceof IBusinessObjectEditen)) || (!b((IBusinessObjectEditen)paramElementList.get(j)).equals(b(paramIBusinessObjectEditen))))
        continue;
      i++;
    }
    return i;
  }

  private IBusinessObjectEditen b(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    for (IBusinessObjectEditen localIBusinessObjectEditen = paramIBusinessObjectEditen; ((localIBusinessObjectEditen.getParent() instanceof IBusinessObjectEditen)) && (!(localIBusinessObjectEditen.getParent() instanceof IBusinessObjectContainer)); localIBusinessObjectEditen = (IBusinessObjectEditen)localIBusinessObjectEditen.getParent());
    return localIBusinessObjectEditen;
  }

  private void a(ElementList paramElementList)
  {
    Object localObject1;
    Object localObject2;
    for (int i = 0; i < paramElementList.size(); i++)
    {
      if ((!(paramElementList.get(i) instanceof IBusinessObjectEditen)) || (a(paramElementList, (IBusinessObjectEditen)paramElementList.get(i)) <= 1))
        continue;
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramElementList.get(i);
      localObject1 = b(localIBusinessObjectEditen);
      localObject2 = new ElementList((IElement)localObject1);
      for (int k = i; k < paramElementList.size(); k++)
      {
        if ((!(paramElementList.get(k) instanceof IBusinessObjectEditen)) || (!b((IBusinessObjectEditen)paramElementList.get(k)).equals(localObject1)))
          continue;
        ((ElementList)localObject2).add((IBusinessObjectEditen)paramElementList.get(k));
        paramElementList.remove(k--);
      }
      paramElementList.add(i, (IElement)localObject2);
    }
    HashMap localHashMap = new HashMap();
    for (int j = 0; j < paramElementList.size(); j++)
      if ((paramElementList.get(j) instanceof IBusinessObjectEditen))
      {
        localObject1 = (IBusinessObjectEditen)paramElementList.get(j);
        if (((IBusinessObjectEditen)localObject1).getShowGroupName().length() <= 0)
          continue;
        paramElementList.remove(j--);
        localObject2 = (ElementList)localHashMap.get(((IBusinessObjectEditen)localObject1).getShowGroupName());
        if (localObject2 == null)
        {
          localObject2 = new ElementList(((IBusinessObjectEditen)localObject1).getShowGroupName());
          localHashMap.put(((IBusinessObjectEditen)localObject1).getShowGroupName(), localObject2);
          j++;
          paramElementList.add(j, (IElement)localObject2);
        }
        if (localObject2 == null)
          continue;
        ((ElementList)localObject2).add((IElement)localObject1);
      }
      else
      {
        if (!(paramElementList.get(j) instanceof ElementList))
          continue;
        localObject1 = (ElementList)paramElementList.get(j);
        if ((((ElementList)localObject1).getElement() == null) || (!(((ElementList)localObject1).getElement() instanceof IBusinessObjectEditen)))
          continue;
        localObject2 = (IBusinessObjectEditen)((ElementList)localObject1).getElement();
        if (((IBusinessObjectEditen)localObject2).getShowGroupName().length() <= 0)
          continue;
        paramElementList.remove(j--);
        ElementList localElementList = (ElementList)localHashMap.get(((IBusinessObjectEditen)localObject2).getShowGroupName());
        if (localElementList == null)
        {
          localElementList = new ElementList(((IBusinessObjectEditen)localObject2).getShowGroupName());
          localHashMap.put(((IBusinessObjectEditen)localObject2).getShowGroupName(), localElementList);
          j++;
          paramElementList.add(j, localElementList);
        }
        if (localElementList == null)
          continue;
        localElementList.add((IElement)localObject1);
      }
  }

  protected void a(l paraml, ElementList paramElementList)
  {
    IElement[] arrayOfIElement = paramElementList.toArray();
    for (int i = 0; i < arrayOfIElement.length; i++)
      if ((arrayOfIElement[i] instanceof ElementList))
      {
        l locall = new l(((ElementList)arrayOfIElement[i]).getDisplayName(), new b(this, ((ElementList)arrayOfIElement[i]).getElement()), ((ElementList)arrayOfIElement[i]).getElement());
        a(locall, (ElementList)arrayOfIElement[i]);
        paraml.a(locall);
      }
      else
      {
        paraml.a(new l(arrayOfIElement[i].getDisplayName(), new b(this, arrayOfIElement[i]), arrayOfIElement[i]));
      }
  }

  public void addElementTokenListener(h paramh)
  {
    this.a.add(paramh);
  }

  public void removeElementTokenListener(h paramh)
  {
    this.a.remove(paramh);
  }

  protected void f()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((h)localIterator.next()).a(getMemberElement());
  }

  protected abstract Iterator e();

  public IElement getMemberElement()
  {
    Envionment localEnvionment = getEnvionment();
    if ((this.c != null) && (this.d == localEnvionment.getMaxModifyTime()))
      return this.c;
    if ((getElementUuid().length() > 0) || (getUniqueName().length() > 0))
      this.c = d();
    if (this.c != null)
    {
      if (!this.c.getUuid().equals(this.elementUuid))
      {
        setElementUuid(this.c.getUuid());
        IRuleContainer localIRuleContainer = getRoot();
        if (localIRuleContainer != null)
          localIRuleContainer.setNeedSave();
      }
      b(this.c);
      this.d = localEnvionment.getMaxModifyTime();
    }
    return this.c;
  }

  protected abstract IElement d();

  public IElement getBusinessObject()
  {
    IElement localIElement = d();
    if ((localIElement instanceof IBusinessObject))
      return (IBusinessObject)localIElement;
    return null;
  }

  public String getDisplayName()
  {
    IElement localIElement = getMemberElement();
    if (localIElement != null)
      setDisplayName(localIElement.getShowDisplayName());
    return super.getDisplayName();
  }

  public void setMemberElement(IElement paramIElement)
  {
    if (paramIElement == null)
      return;
    this.c = null;
    this.elementUuid = paramIElement.getUuid();
    b(paramIElement);
    setDisplayName(paramIElement.getShowDisplayName());
    f();
  }

  protected abstract void b(IElement paramIElement);

  public boolean hasLeftPopupMenus()
  {
    return true;
  }

  public String getElementUuid()
  {
    return this.elementUuid;
  }

  public String getUniqueName()
  {
    return this.uniqueName;
  }

  public void setElementUuid(String paramString)
  {
    this.elementUuid = paramString;
  }

  public void setUniqueName(String paramString)
  {
    this.uniqueName = paramString;
  }

  public boolean canEdit()
  {
    return false;
  }

  public String getHint()
  {
    throw new UnsupportOperationException();
  }

  public String getText()
  {
    throw new UnsupportOperationException();
  }

  public boolean hasHint()
  {
    return false;
  }

  public void setText(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public String getColorType()
  {
    IElement localIElement = getMemberElement();
    if (localIElement == null)
      return "empty";
    if ((localIElement instanceof BusinessObjectClass))
      return "class";
    if ((localIElement instanceof BusinessObjectAttribute))
      return "classAttribute";
    if ((localIElement instanceof BusinessObjectConstructor))
      return "classConstructor";
    if ((localIElement instanceof ConstantEnum))
      return "constant";
    if ((localIElement instanceof MappingVariable))
      return "inoutVariable";
    if ((localIElement instanceof TempVariable))
      return "tempVariable";
    if ((localIElement instanceof MappingFunction))
      return "staticFunction";
    if ((localIElement instanceof GlobalFunction))
      return "staticFunction";
    if ((localIElement instanceof FunctionMember))
      return "customFunction";
    if ((localIElement instanceof SheetFieldModel))
      return "sheetField";
    if ((localIElement instanceof MapValue))
      return "sheetField";
    if ((localIElement instanceof XmlAttribute))
      return "xmlFunction";
    if ((localIElement instanceof TreeAttribute))
      return "treeFunction";
    if ((localIElement instanceof AbstractExcelFieldModel))
      return "excelFunction";
    if ((localIElement instanceof SoapParameter))
      return "soapFunction";
    if ((localIElement instanceof ISubFunction))
      return getSubFunctionColorType(((ISubFunction)localIElement).getRootMember());
    if ((localIElement instanceof ISubVariable))
      return getSubFunctionColorType(((ISubVariable)localIElement).getRootMember());
    return "default";
  }

  public String getSubFunctionColorType(IBusinessObject paramIBusinessObject)
  {
    if (paramIBusinessObject == null)
      return "subFunction";
    if ((paramIBusinessObject instanceof SheetTable))
      return "sheetFunction";
    if ((paramIBusinessObject instanceof SheetMap))
      return "sheetFunction";
    if ((paramIBusinessObject instanceof IBOAndContainer))
      return "tableFunction";
    if (((paramIBusinessObject instanceof CustomSql)) || ((paramIBusinessObject instanceof DBModel)))
      return "tableFunction";
    if ((paramIBusinessObject instanceof IExcelObject))
      return "excelFunction";
    if ((paramIBusinessObject instanceof SoapService))
      return "soapFunction";
    if ((paramIBusinessObject instanceof XmlNode))
      return "xmlFunction";
    if ((paramIBusinessObject instanceof TreeValueNode))
      return "treeFunction";
    if ((paramIBusinessObject instanceof TableFunction))
      return "tableFunction";
    if ((paramIBusinessObject instanceof BusinessObjectClass))
      return "classMethod";
    if ((paramIBusinessObject instanceof BusinessObjectAttribute))
      return "classAttribute";
    if ((paramIBusinessObject instanceof BusinessObjectConstructor))
      return "classConstructor";
    if ((paramIBusinessObject instanceof ConstantEnum))
      return "constant";
    if ((paramIBusinessObject instanceof MappingVariable))
      return "inoutVariable";
    if ((paramIBusinessObject instanceof TempVariable))
      return "tempVariable";
    if ((paramIBusinessObject instanceof MappingFunction))
      return "staticFunction";
    if ((paramIBusinessObject instanceof FunctionMember))
      return "customFunction";
    if ((paramIBusinessObject instanceof SheetFieldModel))
      return "sheetField";
    if ((paramIBusinessObject instanceof MapValue))
      return "sheetField";
    if ((paramIBusinessObject instanceof XmlAttribute))
      return "xmlFunction";
    if ((paramIBusinessObject instanceof TreeAttribute))
      return "treeFunction";
    if ((paramIBusinessObject instanceof AbstractExcelFieldModel))
      return "excelFunction";
    if ((paramIBusinessObject instanceof SoapParameter))
      return "soapFunction";
    if ((paramIBusinessObject instanceof BusinessObjectMethod))
      return "classMethod";
    if ((paramIBusinessObject instanceof ISubFunction))
      return "subFunction";
    return "subFunction";
  }

  public void findRelateObject(Map paramMap)
  {
    IElement localIElement = getMemberElement();
    if (localIElement != null)
      paramMap.put(localIElement, localIElement);
    super.findRelateObject(paramMap);
  }

  public void findAssignObject(Map paramMap, boolean paramBoolean)
  {
    if (((getParent() instanceof AssignToken)) || ((getParent() instanceof PackageFieldSet)))
    {
      IElement localIElement = getMemberElement();
      if ((localIElement != null) && ((localIElement instanceof IVariableObject)) && ((((IVariableObject)localIElement).isLoged()) || (!paramBoolean)))
        paramMap.put(localIElement, localIElement);
      super.findAssignObject(paramMap, paramBoolean);
    }
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    return false;
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.AbstractElementToken
 * JD-Core Version:    0.6.0
 */