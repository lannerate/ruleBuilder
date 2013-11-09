package com.flagleader.repository.xml;

import com.flagleader.engine.Property;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.BusinessObjectMethod;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.AbstractBOContainer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import com.flagleader.xml.Node;
import com.flagleader.xml.XmlFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlNode extends AbstractBOContainer
  implements IBusinessObjectContainer, IBOAndContainer, IBusinessObjectEditen
{
  public static final String NAME = "xmlNode";
  public static final String DISPLAYNAME = getLocalString("xmlNode.text");
  private String nodeName = null;
  private String resourceName = null;
  private String encoding = Property.getInstance().getXmlEncoding();
  private int multiType = 1;
  public static final int ONENULL = 0;
  public static final int ONEMUST = 1;
  public static final int MULTINULL = 2;
  public static final int MULTIMUST = 3;
  private int loadType = 1;
  public static final int AUTOLOAD = 0;
  public static final int CUSTOMLOAD = 1;
  public static final int LOADFILE = 2;
  public static final int TEMPNEW = 3;
  private transient d updater = null;

  public XmlNode(XmlNode paramXmlNode)
  {
    super(paramXmlNode);
    this.resourceName = paramXmlNode.resourceName;
    this.nodeName = paramXmlNode.nodeName;
    this.loadType = paramXmlNode.loadType;
    this.multiType = paramXmlNode.multiType;
    this.encoding = paramXmlNode.encoding;
  }

  public XmlNode()
  {
  }

  public XmlNode(String paramString)
  {
    super(paramString);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitXmlNode(this);
  }

  public String getName()
  {
    return "xmlNode";
  }

  public IElement deepClone()
  {
    return new XmlNode(this);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return (paramITreeNode instanceof XmlNode);
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return paramString.equals("xmlNode");
  }

  public ITreeNode createChildNode(String paramString)
  {
    if (paramString.equals("xmlNode"))
    {
      XmlNode localXmlNode = new XmlNode(getChildDefaultName(DISPLAYNAME));
      addChildElement(localXmlNode);
      localXmlNode.updateFunction();
      setModified(true);
      updateTree();
      return localXmlNode;
    }
    return super.createChildNode(paramString);
  }

  public boolean canDelete()
  {
    return true;
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return true;
  }

  public boolean paste(ITreeNode paramITreeNode)
  {
    if (super.paste(paramITreeNode))
    {
      updateViewer();
      return true;
    }
    return false;
  }

  public boolean canRename()
  {
    return true;
  }

  protected boolean a(IElement paramIElement)
  {
    if (b())
      return false;
    return ((paramIElement instanceof XmlNode)) || ((paramIElement instanceof XmlAttribute)) || ((paramIElement instanceof XmlFunction)) || ((paramIElement instanceof BusinessObjectMethod));
  }

  public String getVarName()
  {
    if ((getParent() instanceof XmlNode))
    {
      if (StringUtil.isJavaLetter(getNodeName()))
        return ((XmlNode)getParent()).getVarName() + "_" + getNodeName();
      return ((XmlNode)getParent()).getVarName() + "_" + getParent().getElementPos(this);
    }
    if (StringUtil.isJavaLetter(getNodeName()))
      return getNodeName();
    if (getParent() != null)
      return "xml" + getParent().getElementPos(this);
    return getNodeName();
  }

  public XmlFunction getXmlFunction(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof XmlFunction)) && (((XmlFunction)localObject).getValueName().equals(paramString)))
        return (XmlFunction)localObject;
    }
    return null;
  }

  protected XmlAttribute a(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof XmlAttribute)) && (((XmlAttribute)localObject).getKey().equalsIgnoreCase(paramString)))
        return (XmlAttribute)localObject;
    }
    return null;
  }

  public Iterator getEditens()
  {
    return d().iterator();
  }

  protected List d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public List getAllFunctions()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof XmlFunction))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public Node getFormatNode()
  {
    Node localNode = XmlFactory.newIntance().newNode(getNodeName());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (!(localObject1 instanceof XmlAttribute))
        continue;
      localNode.setAttribute(((XmlAttribute)localObject1).getKey(), ((XmlAttribute)localObject1).getDisplayName());
    }
    int i = 0;
    localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (!(localObject2 instanceof XmlNode))
        continue;
      localNode.addNode(((XmlNode)localObject2).getFormatNode());
      i = 1;
    }
    if (i == 0)
      localNode.setText(getDisplayName());
    return localNode;
  }

  public String getFormatXml()
  {
    Node localNode = getFormatNode();
    localNode.setEncoding(this.encoding);
    return localNode.getContent();
  }

  public List getAllKeys()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getNodeName());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof XmlAttribute)) || (!(localObject instanceof XmlNode)))
        continue;
      localArrayList.addAll(((XmlNode)localObject).getAllKeys());
    }
    return localArrayList;
  }

  public List getAllAttributes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof XmlAttribute))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public List getAllEditens()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localObject);
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localObject;
      localArrayList.addAll(localIBusinessObjectEditen.getAllSubEditens());
    }
    return localArrayList;
  }

  public List getAllNodes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof XmlNode))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  protected List b(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new MethodParam(paramString, 0));
    return localArrayList;
  }

  protected List a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(1);
    for (int i = 0; i < paramArrayOfString.length; i++)
      localArrayList.add(new MethodParam(paramArrayOfString[i], i));
    return localArrayList;
  }

  public void updateFunction()
  {
    if (getXmlFunction("loadFromString") == null)
      addChildElement(new XmlFunction("loadFromString", "void", "loadFromString({arg1})", format("loadFromString.xml", new Object[] { "{arg1}", getDisplayName() }), b("string")));
    else
      getXmlFunction("loadFromString").setDisplayName(format("loadFromString.xml", new Object[] { "{arg1}", getDisplayName() }));
    if (getXmlFunction("init") == null)
    {
      addChildElement(new XmlFunction("init", "void", " = initXmlNode(\"$p\")", format("init.xml", new Object[] { getDisplayName() }), null));
    }
    else
    {
      getXmlFunction("init").setDisplayName(format("init.xml", new Object[] { getDisplayName() }));
      getXmlFunction("init").setVariableName(" = initXmlNode(\"$p\")");
    }
    if (getXmlFunction("getContent") == null)
      addChildElement(new XmlFunction("getContent", "string", "getContent()", format("getContent.xml", new Object[] { getDisplayName() }), null));
    else
      getXmlFunction("getContent").setDisplayName(format("getContent.xml", new Object[] { getDisplayName() }));
    if (getXmlFunction("addNode") == null)
      addChildElement(new XmlFunction("addNode", "void", "addNode({arg1})", format("addNode.xml", new Object[] { "{arg1}", getDisplayName() }), b("xml")));
    else
      getXmlFunction("addNode").setDisplayName(format("addNode.xml", new Object[] { "{arg1}", getDisplayName() }));
    if (getXmlFunction("getNode") == null)
      addChildElement(new XmlFunction("getNode", "xml", "getNode({arg1})", format("getNode.xml", new Object[] { getDisplayName(), "{arg1}" }), b("string")));
    else
      getXmlFunction("getNode").setDisplayName(format("getNode.xml", new Object[] { getDisplayName(), "{arg1}" }));
    if (getXmlFunction("getnodes") == null)
      addChildElement(new XmlFunction("getnodes", "list<xml>", "getNodes({arg1})", format("getNodes.xml", new Object[] { getDisplayName() }), b("string")));
    else
      getXmlFunction("getnodes").setDisplayName(format("getNodes.xml", new Object[] { getDisplayName() }));
    if (getXmlFunction("dispose") == null)
      addChildElement(new XmlFunction("dispose", "void", "dispose()", format("dispose.xml", new Object[] { getDisplayName() }), null));
    else
      getXmlFunction("dispose").setDisplayName(format("dispose.xml", new Object[] { getDisplayName() }));
    if (getXmlFunction("removeNode") == null)
      addChildElement(new XmlFunction("removeNode", "void", "removeNode({arg1})", format("removeNode.xml", new Object[] { getDisplayName(), "{arg1}" }), a(new String[] { "string" })));
    else
      getXmlFunction("removeNode").setDisplayName(format("removeNode.xml", new Object[] { getDisplayName(), "{arg1}" }));
    if (getXmlFunction("removeNode2") == null)
      addChildElement(new XmlFunction("removeNode2", "void", "removeNode({arg1})", format("removeNode2.xml", new Object[] { getDisplayName(), "{arg1}" }), a(new String[] { "xml" })));
    else
      getXmlFunction("removeNode2").setDisplayName(format("removeNode2.xml", new Object[] { getDisplayName(), "{arg1}" }));
    if (getXmlFunction("gettext") == null)
      addChildElement(new XmlFunction("gettext", "string", "getText()", format("getText.xml", new Object[] { getDisplayName() }), null));
    else
      getXmlFunction("gettext").setDisplayName(format("getText.xml", new Object[] { getDisplayName() }));
    if (getXmlFunction("settext") == null)
      addChildElement(new XmlFunction("settext", "void", "setText({arg1})", format("setText.xml", new Object[] { getDisplayName(), "{arg1}" }), a(new String[] { "string" })));
    else
      getXmlFunction("settext").setDisplayName(format("setText.xml", new Object[] { getDisplayName(), "{arg1}" }));
    if (getXmlFunction("getcdata") == null)
      addChildElement(new XmlFunction("getcdata", "string", "getCData()", format("getCData.xml", new Object[] { getDisplayName() }), null));
    else
      getXmlFunction("getcdata").setDisplayName(format("getCData.xml", new Object[] { getDisplayName() }));
    if (getXmlFunction("setcdata") == null)
      addChildElement(new XmlFunction("setcdata", "void", "setCData({arg1})", format("setCData.xml", new Object[] { getDisplayName(), "{arg1}" }), a(new String[] { "string" })));
    else
      getXmlFunction("setcdata").setDisplayName(format("setCData.xml", new Object[] { getDisplayName(), "{arg1}" }));
    if (getXmlFunction("clear") == null)
      addChildElement(new XmlFunction("clear", "void", "clear()", format("clear.xml", new Object[] { getDisplayName() }), null));
    else
      getXmlFunction("clear").setDisplayName(format("clear.xml", new Object[] { getDisplayName() }));
  }

  public XmlAttribute addAttribute(String paramString1, String paramString2, String paramString3)
  {
    XmlAttribute localXmlAttribute = a(paramString1);
    if (localXmlAttribute == null)
    {
      localXmlAttribute = new XmlAttribute(paramString1, paramString2, paramString3);
      addChildElement(localXmlAttribute);
    }
    return localXmlAttribute;
  }

  public void addFunction(String paramString1, String paramString2, String paramString3)
  {
    addChildElement(new XmlFunction("get" + c(paramString1), paramString2, "get" + getTypeManager().a(getTypeManager().a(paramString2)) + "(\"" + paramString1 + "\")", paramString3, null));
    addChildElement(new XmlFunction("set" + c(paramString1), "void", "set" + getTypeManager().a(getTypeManager().a(paramString2)) + "(\"" + paramString1 + "\",{arg1})", paramString3 + " " + getLocalString("equels.xml") + "{arg1}", b(paramString2)));
  }

  public XmlFunction getGetFunction(XmlAttribute paramXmlAttribute)
  {
    return getXmlFunction("get" + c(paramXmlAttribute.getKey()));
  }

  public XmlFunction getSetFunction(XmlAttribute paramXmlAttribute)
  {
    return getXmlFunction("Set" + c(paramXmlAttribute.getKey()));
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  private String c(String paramString)
  {
    return paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
  }

  public String getResourceName()
  {
    if (this.resourceName == null)
      return getNodeName();
    return this.resourceName;
  }

  public void setResourceName(String paramString)
  {
    this.resourceName = paramString;
  }

  public int getLoadType()
  {
    return this.loadType;
  }

  public void setLoadType(int paramInt)
  {
    this.loadType = paramInt;
  }

  public String getNodeName()
  {
    if (this.nodeName == null)
      return getDisplayName();
    return this.nodeName;
  }

  public void setNodeName(String paramString)
  {
    this.nodeName = paramString;
  }

  public boolean isRootElement()
  {
    return (getParent() == null) || (!(getParent() instanceof XmlNode));
  }

  public XmlNode getRootElement()
  {
    if ((getParent() != null) && ((getParent() instanceof XmlNode)))
      return ((XmlNode)getParent()).getRootElement();
    return this;
  }

  public void changeValueType(String paramString)
  {
  }

  public List getAllParams()
  {
    return new ArrayList(0);
  }

  public IBusinessObjectContainer getContainer()
  {
    return this;
  }

  public g getJavaType()
  {
    return getTypeManager().a(getValueType());
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public String getUniqueName()
  {
    IElement localIElement = getParent();
    if ((localIElement != null) && ((localIElement instanceof XmlNode)))
      return ((XmlNode)localIElement).getUniqueName() + "." + getNodeName();
    return getNodeName();
  }

  public String getValueName()
  {
    return getResourceName();
  }

  public String getValueType()
  {
    return "com.flagleader.xml.Node";
  }

  public String getVarValue()
  {
    return getVarName();
  }

  public void setVisible(boolean paramBoolean)
  {
  }

  public boolean canCreateEditen()
  {
    return false;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    return null;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof XmlAttribute))
    {
      initUndoable();
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(paramIElement, paramInt);
      else
        addChildElement(paramIElement);
      takeSnapshot();
      setModified(true);
      return true;
    }
    Object localObject1;
    if (((paramIElement instanceof IVariableObject)) || ((paramIElement instanceof FieldModel)))
    {
      IBusinessObjectEditen localIBusinessObjectEditen1 = (IBusinessObjectEditen)paramIElement;
      initUndoable();
      localObject1 = new XmlAttribute();
      ((XmlAttribute)localObject1).setKey(localIBusinessObjectEditen1.getValueName());
      ((XmlAttribute)localObject1).setDisplayName(localIBusinessObjectEditen1.getDisplayName());
      ((XmlAttribute)localObject1).changeValueType(localIBusinessObjectEditen1.getValueType());
      ((XmlAttribute)localObject1).setVisible(localIBusinessObjectEditen1.isVisible());
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement((IElement)localObject1, paramInt);
      else
        addChildElement((IElement)localObject1);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof ElementContainer))
    {
      if (paramInt < 0)
        paramInt = getChildrenCount();
      initUndoable();
      int i = 0;
      localObject1 = ((ElementContainer)paramIElement).getChildrenIterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof XmlAttribute))
        {
          addChildElement((XmlAttribute)localObject2, paramInt++);
          i = 1;
        }
        else
        {
          if ((!(localObject2 instanceof IVariableObject)) && (!(localObject2 instanceof FieldModel)))
            continue;
          IBusinessObjectEditen localIBusinessObjectEditen2 = (IBusinessObjectEditen)localObject2;
          initUndoable();
          XmlAttribute localXmlAttribute = new XmlAttribute();
          localXmlAttribute.setKey(localIBusinessObjectEditen2.getValueName());
          localXmlAttribute.setDisplayName(localIBusinessObjectEditen2.getDisplayName());
          localXmlAttribute.changeValueType(localIBusinessObjectEditen2.getValueType());
          localXmlAttribute.setVisible(localIBusinessObjectEditen2.isVisible());
          addChildElement(localXmlAttribute, paramInt++);
          i = 1;
        }
      }
      if (i != 0)
      {
        takeSnapshot();
        setModified(true);
      }
      return true;
    }
    return false;
  }

  public void sortBy(int paramInt, String paramString, boolean paramBoolean)
  {
  }

  public List getCanCreateSubFunction()
  {
    return getEnvionment().getClassMembers(this, true);
  }

  public boolean createSubFunction(List paramList)
  {
    int i = 0;
    for (int j = 0; j < paramList.size(); j++)
    {
      ((IBusinessObject)paramList.get(j)).setVisible(true);
      addChildElement((IBusinessObject)paramList.get(j));
      i = 1;
    }
    return i;
  }

  public boolean isEditVisible()
  {
    return false;
  }

  public void setObjectEditor(d paramd)
  {
    this.updater = paramd;
  }

  public void updateEditor()
  {
    if (this.updater != null)
      this.updater.a();
  }

  public void update()
  {
    updateEditor();
  }

  public int getMultiType()
  {
    return this.multiType;
  }

  public void setMultiType(int paramInt)
  {
    this.multiType = paramInt;
  }

  public String getEncoding()
  {
    return this.encoding;
  }

  public void setEncoding(String paramString)
  {
    this.encoding = paramString;
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
  }

  public void setModified(boolean paramBoolean)
  {
    super.setModified(paramBoolean);
    if ((paramBoolean) && (getEnvionment() != null))
      getEnvionment().setModified(true);
  }

  public boolean canCreateSubFunction()
  {
    return false;
  }

  public void changeDisplayName(String paramString1, String paramString2)
  {
  }

  public List getAllSubEditens()
  {
    return d();
  }

  public String getShowGroupName()
  {
    return "";
  }

  public String getStringPos(int paramInt)
  {
    return null;
  }

  public Iterator getSubEditens()
  {
    return getEditens();
  }

  public boolean hasSubEditen()
  {
    return true;
  }

  public boolean isGroupEditable()
  {
    return false;
  }

  public boolean isTypeEditable()
  {
    return false;
  }

  public boolean isValueEditable()
  {
    return false;
  }

  public void setShowGroupName(String paramString)
  {
  }

  public void setValueName(String paramString)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.xml.XmlNode
 * JD-Core Version:    0.6.0
 */