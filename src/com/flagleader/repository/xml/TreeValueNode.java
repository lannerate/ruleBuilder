package com.flagleader.repository.xml;

import com.flagleader.engine.MemoryShare;
import com.flagleader.engine.Property;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d;
import com.flagleader.repository.db.AbstractBOAndContainer;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.BusinessObjectMethod;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import com.flagleader.xml.Node;
import com.flagleader.xml.TreeValue;
import com.flagleader.xml.XmlFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeValueNode extends AbstractBOAndContainer
  implements IBusinessObjectContainer, IBOAndContainer, IBusinessObjectEditen, IWhileObject
{
  public static final String NAME = "TreeValueNode";
  public static final String DISPLAYNAME = getLocalString("TreeValueNode.text");
  public static final String ROOTNAME = getLocalString("TreeValueNode.root");
  private String nodeName = null;
  private String resourceName = null;
  private String encoding = Property.getInstance().getXmlEncoding();
  private int multiType = 0;
  public static final int ONEMUST = 0;
  public static final int MULTINULL = 1;
  private int shareType = 0;
  private int loadType = 1;
  public static final int AUTOLOAD = 0;
  public static final int CUSTOMLOAD = 1;
  public static final int LOADFILE = 2;
  public static final int TEMPNEW = 3;
  private transient d updater = null;
  private int inout = 0;

  public int getInout()
  {
    return this.inout;
  }

  public void setInout(int paramInt)
  {
    this.inout = paramInt;
  }

  public TreeValueNode(TreeValueNode paramTreeValueNode)
  {
    super(paramTreeValueNode);
    this.resourceName = paramTreeValueNode.resourceName;
    this.nodeName = paramTreeValueNode.nodeName;
    this.loadType = paramTreeValueNode.loadType;
    this.multiType = paramTreeValueNode.multiType;
    this.encoding = paramTreeValueNode.encoding;
    this.shareType = paramTreeValueNode.shareType;
  }

  public TreeValueNode()
  {
  }

  public TreeValueNode(String paramString)
  {
    super(paramString);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitTreeNode(this);
  }

  public String getName()
  {
    return "TreeValueNode";
  }

  public IElement deepClone()
  {
    return new TreeValueNode(this);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return (paramITreeNode instanceof TreeValueNode);
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return paramString.equals("TreeValueNode");
  }

  public ITreeNode createChildNode(String paramString)
  {
    if (paramString.equals("TreeValueNode"))
    {
      TreeValueNode localTreeValueNode = new TreeValueNode(getChildDefaultName(DISPLAYNAME));
      addChildElement(localTreeValueNode);
      localTreeValueNode.resetFunction();
      setModified(true);
      updateTree();
      return localTreeValueNode;
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
    return ((paramIElement instanceof TreeValueNode)) || ((paramIElement instanceof TreeAttribute)) || ((paramIElement instanceof TreeFunction)) || ((paramIElement instanceof BusinessObjectMethod));
  }

  public String getVarName()
  {
    if ((getParent() instanceof TreeValueNode))
      return ((TreeValueNode)getParent()).getVarName() + "_" + getNodeName();
    if (StringUtil.isJavaLetter(getNodeName()))
      return getNodeName();
    if (getParent() != null)
      return "tree" + getParent().getElementPos(this);
    return "";
  }

  public String getVarValue()
  {
    if ((getParent() instanceof TreeValueNode))
      return ((TreeValueNode)getParent()).getVarValue() + ".getTree(" + ((TreeValueNode)getParent()).getSubPos(this) + ")";
    if (StringUtil.isJavaLetter(getNodeName()))
      return getNodeName();
    if (getParent() != null)
      return "tree" + getParent().getElementPos(this);
    return getNodeName();
  }

  public String getVarSaveValue()
  {
    if ((getParent() instanceof TreeValueNode))
      return ((TreeValueNode)getParent()).getVarSaveValue() + ".getSaveTree(" + ((TreeValueNode)getParent()).getSubPos(this) + ")";
    if (StringUtil.isJavaLetter(getNodeName()))
      return getNodeName();
    if (getParent() != null)
      return "tree" + getParent().getElementPos(this);
    return getNodeName();
  }

  public TreeValueNode getSubTreeNode(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof TreeValueNode)) && (((TreeValueNode)localObject).getNodeName().equals(paramString)))
        return (TreeValueNode)localObject;
    }
    return null;
  }

  public TreeFunction getTreeFunction(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof TreeFunction)) && (((TreeFunction)localObject).getValueName().equals(paramString)))
        return (TreeFunction)localObject;
    }
    return null;
  }

  public TreeAttribute getAttribute(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof TreeAttribute)) && (((TreeAttribute)localObject).getKey().equalsIgnoreCase(paramString)))
        return (TreeAttribute)localObject;
    }
    return null;
  }

  public boolean exitsFields(Object paramObject)
  {
    if (!(paramObject instanceof TreeAttribute))
      return false;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof TreeAttribute)) && (((TreeAttribute)localObject).getKey().equals(((TreeAttribute)paramObject).getKey())) && (((TreeAttribute)localObject).getDisplayName().equals(((TreeAttribute)paramObject).getDisplayName())))
        return true;
    }
    return false;
  }

  public Iterator getEditens()
  {
    return e().iterator();
  }

  protected List e()
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
      if (!(localObject instanceof TreeFunction))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public void getInfoDefines(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append("new TreeNodeInfo(\"");
    paramStringBuffer.append(StringUtil.formatJavaDefine(getNodeName()));
    paramStringBuffer.append("\",\"");
    paramStringBuffer.append(StringUtil.formatJavaDefine(getDisplayName()));
    paramStringBuffer.append("\",");
    paramStringBuffer.append(getMultiType());
    paramStringBuffer.append(",\"");
    List localList1 = getFields();
    for (int i = 0; i < localList1.size(); i++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)localList1.get(i);
      paramStringBuffer.append("");
      paramStringBuffer.append(StringUtil.formatJavaDefine(localTreeAttribute.getKey()));
      paramStringBuffer.append(",");
      paramStringBuffer.append(localTreeAttribute.getValueType());
      paramStringBuffer.append(",");
      paramStringBuffer.append(StringUtil.formatJavaDefine(localTreeAttribute.getDisplayName()));
      paramStringBuffer.append(",");
      paramStringBuffer.append(StringUtil.stringValue(localTreeAttribute.getLocate()));
      paramStringBuffer.append("");
      if (i >= localList1.size() - 1)
        continue;
      paramStringBuffer.append(";");
    }
    paramStringBuffer.append("\",new TreeNodeInfo[]{");
    List localList2 = getAllNodes();
    for (int j = 0; j < localList2.size(); j++)
    {
      TreeValueNode localTreeValueNode = (TreeValueNode)localList2.get(j);
      localTreeValueNode.getInfoDefines(paramStringBuffer);
      if (j >= localList2.size() - 1)
        continue;
      paramStringBuffer.append(",");
    }
    paramStringBuffer.append("})");
  }

  public String getInfoString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    getInfoDefines(localStringBuffer);
    return localStringBuffer.toString();
  }

  public Node getFormatNode()
  {
    Node localNode = XmlFactory.newIntance().newNode(getNodeName());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (!(localObject1 instanceof TreeAttribute))
        continue;
      if (((TreeAttribute)localObject1).getLocate() == 1)
        localNode.setAttribute(((TreeAttribute)localObject1).getKey(), ((TreeAttribute)localObject1).getDisplayName());
      else if (((TreeAttribute)localObject1).getKey().length() > 0)
        localNode.addText(((TreeAttribute)localObject1).getKey(), ((TreeAttribute)localObject1).getDisplayName());
      else
        localNode.setText(((TreeAttribute)localObject1).getDisplayName());
    }
    int i = 0;
    localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (!(localObject2 instanceof TreeValueNode))
        continue;
      localNode.addNode(((TreeValueNode)localObject2).getFormatNode());
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
      if ((localObject instanceof TreeAttribute))
      {
        localArrayList.add(((TreeAttribute)localObject).getKey());
      }
      else
      {
        if (!(localObject instanceof TreeValueNode))
          continue;
        localArrayList.addAll(((TreeValueNode)localObject).getAllKeys());
      }
    }
    return localArrayList;
  }

  public List getFieldNameKey()
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(getNodeName());
    return localArrayList;
  }

  public List getFields()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof TreeAttribute))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public Iterator getFieldIterator()
  {
    return getAcceptChildren(new a(this));
  }

  public Iterator getNodesIterator()
  {
    return getAcceptChildren(new b(this));
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
      if (!(localObject instanceof TreeValueNode))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  protected List a(String paramString)
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

  public void clearfunction()
  {
    for (int i = a().size() - 1; i >= 0; i--)
    {
      if (!(a().get(i) instanceof TreeFunction))
        continue;
      removeElement(i);
    }
  }

  public void resetFunction()
  {
    if (isSingleValue())
      clearfunction();
    else
      updateFunction();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof TreeValueNode))
        continue;
      ((TreeValueNode)localObject).resetFunction();
    }
    setModified(true);
  }

  public void updateFunction()
  {
    if (getTreeFunction("loadFromView") == null)
    {
      addChildElement(new TreeFunction("loadFromView", "void", "loadFromView({arg1})", format("loadFromView.sheet", new Object[] { "{arg1}", getDisplayName() }), a("com.flagleader.db.IResult"), false, getLocalString("loadFromView.sheetgroup")));
    }
    else
    {
      getTreeFunction("loadFromView").setDisplayName(format("loadFromView.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("loadFromView").setGroupName(getLocalString("loadFromView.sheetgroup"));
    }
    if (getTreeFunction("loadFromResult") == null)
    {
      addChildElement(new TreeFunction("loadFromResult", "void", "loadFromResult({arg1})", format("loadFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }), a("resultandfields"), false, getLocalString("loadFromResult.sheetgroup")));
    }
    else
    {
      getTreeFunction("loadFromResult").setDisplayName(format("loadFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("loadFromResult").setGroupName(getLocalString("loadFromResult.sheetgroup"));
    }
    if (getTreeFunction("appendFromResult") == null)
    {
      addChildElement(new TreeFunction("appendFromResult", "void", "appendFromResult({arg1})", format("appendFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }), a("resultandfields"), false, getLocalString("appendFromResult.sheetgroup")));
    }
    else
    {
      getTreeFunction("appendFromResult").setDisplayName(format("appendFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("appendFromResult").setGroupName(getLocalString("appendFromResult.sheetgroup"));
    }
    if (getTreeFunction("updateBySheet") == null)
    {
      addChildElement(new TreeFunction("updateBySheet", "void", "updateBySheet({arg1},{arg2},{arg3})", format("updateBySheet.sheet", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }), a(new String[] { "com.flagleader.db.Sheet", "sheetfields", "sheetfields" }), false, getLocalString("updateBySheet.sheetgroup")));
    }
    else
    {
      getTreeFunction("updateBySheet").setDisplayName(format("updateBySheet.sheet", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }));
      getTreeFunction("updateBySheet").setGroupName(getLocalString("updateBySheet.sheetgroup"));
    }
    if (getTreeFunction("updateFromSheet") == null)
    {
      addChildElement(new TreeFunction("updateFromSheet", "void", "updateFromSheet({arg1})", format("updateFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a(new String[] { "sheetandwheres" }), false, getLocalString("updateFromSheet.sheetgroup")));
    }
    else
    {
      getTreeFunction("updateFromSheet").setDisplayName(format("updateFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("updateFromSheet").setGroupName(getLocalString("updateFromSheet.sheetgroup"));
    }
    if (getTreeFunction("updateByResult") == null)
    {
      addChildElement(new TreeFunction("updateByResult", "void", "updateByResult({arg1},{arg2},{arg3})", format("updateByResult.sheet", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }), a(new String[] { "com.flagleader.db.IResult", "sheetfields", "sheetfields" }), false, getLocalString("updateByResult.sheetgroup")));
    }
    else
    {
      getTreeFunction("updateByResult").setDisplayName(format("updateByResult.sheet", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }));
      getTreeFunction("updateByResult").setGroupName(getLocalString("updateByResult.sheetgroup"));
    }
    if (getTreeFunction("updateFromResult") == null)
    {
      addChildElement(new TreeFunction("updateFromResult", "void", "updateFromResult({arg1})", format("updateFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }), a(new String[] { "resultandwheres" }), false, getLocalString("updateFromResult.sheetgroup")));
    }
    else
    {
      getTreeFunction("updateFromResult").setDisplayName(format("updateFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("updateFromResult").setGroupName(getLocalString("updateFromResult.sheetgroup"));
    }
    if (getTreeFunction("loadFromSheet") == null)
    {
      addChildElement(new TreeFunction("loadFromSheet", "void", "loadFromSheet({arg1})", format("loadFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a("com.flagleader.db.Sheet"), false, getLocalString("loadFromSheet.sheetgroup")));
    }
    else
    {
      getTreeFunction("loadFromSheet").setDisplayName(format("loadFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("loadFromSheet").setGroupName(getLocalString("loadFromSheet.sheetgroup"));
    }
    if (getTreeFunction("initFromSheet") == null)
    {
      addChildElement(new TreeFunction("initFromSheet", "void", "initFromSheet({arg1})", format("initFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a("sheetandfields"), false, getLocalString("initFromSheet.sheetgroup")));
    }
    else
    {
      getTreeFunction("initFromSheet").setDisplayName(format("initFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("initFromSheet").setGroupName(getLocalString("initFromSheet.sheetgroup"));
    }
    if (getTreeFunction("appendFromSheet") == null)
    {
      addChildElement(new TreeFunction("appendFromSheet", "void", "appendFromSheet({arg1})", format("appendFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a("sheetandfields"), false, getLocalString("appendFromSheet.sheetgroup")));
    }
    else
    {
      getTreeFunction("appendFromSheet").setDisplayName(format("appendFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("appendFromSheet").setGroupName(getLocalString("appendFromSheet.sheetgroup"));
    }
    if (getTreeFunction("createSheet") == null)
    {
      addChildElement(new TreeFunction("createSheet", "sheet", "createSheet({arg1},{arg2},{arg3})", format("createSheet.sheet", new Object[] { getDisplayName(), "{arg1}", "{arg2}", "{arg3}" }), a(new String[] { "sheetfuncs", "sheetfields", "sheetwheres" }), false, getLocalString("createSheet.sheetgroup")));
    }
    else
    {
      getTreeFunction("createSheet").setDisplayName(format("createSheet.sheet", new Object[] { getDisplayName(), "{arg1}", "{arg2}", "{arg3}" }));
      getTreeFunction("createSheet").setGroupName(getLocalString("createSheet.sheetgroup"));
    }
    if (getTreeFunction("updateByDynamicSheet") == null)
    {
      addChildElement(new TreeFunction("updateByDynamicSheet", "void", "updateByDynamicSheet({arg1})", format("updateByDynamicSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a(new String[] { "sheetdynamic" }), false, getLocalString("updateByDynamicSheet.sheetgroup")));
    }
    else
    {
      getTreeFunction("updateByDynamicSheet").setDisplayName(format("updateByDynamicSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("updateByDynamicSheet").setGroupName(getLocalString("updateByDynamicSheet.sheetgroup"));
    }
    if (getTreeFunction("beforeFirst") == null)
    {
      addChildElement(new TreeFunction("beforeFirst", "void", "beforeFirst()", format("beforeFirst.sheet", new Object[] { getDisplayName() }), null, getLocalString("beforeFirst.sheetgroup")));
    }
    else
    {
      getTreeFunction("beforeFirst").setDisplayName(format("beforeFirst.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("beforeFirst").setGroupName(getLocalString("beforeFirst.sheetgroup"));
    }
    if (getTreeFunction("next") == null)
    {
      addChildElement(new TreeFunction("next", "boolean", "next()", format("next.sheet", new Object[] { getDisplayName() }), null, getLocalString("next.sheetgroup")));
    }
    else
    {
      getTreeFunction("next").setDisplayName(format("next.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("next").setGroupName(getLocalString("next.sheetgroup"));
    }
    if (getTreeFunction("getListResult") == null)
    {
      addChildElement(new TreeFunction("getListResult", "list<list>", "getListResult()", format("getListResult.sheet", new Object[] { getDisplayName() }), null, getLocalString("getListResult.sheetgroup")));
    }
    else
    {
      getTreeFunction("getListResult").setDisplayName(format("getListResult.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("getListResult").setGroupName(getLocalString("getListResult.sheetgroup"));
    }
    if (getTreeFunction("loadFromList") == null)
    {
      addChildElement(new TreeFunction("loadFromList", "void", "loadFromList({arg1})", format("loadFromList.sheet", new Object[] { "{arg1}", getDisplayName() }), a("list<list>"), false, getLocalString("loadFromList.sheetgroup")));
    }
    else
    {
      getTreeFunction("loadFromList").setDisplayName(format("loadFromList.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTreeFunction("loadFromList").setGroupName(getLocalString("loadFromList.sheetgroup"));
    }
    if (getTreeFunction("getRows") == null)
    {
      addChildElement(new TreeFunction("getRows", "int", "getRows()", format("getRows.sheet", new Object[] { getDisplayName() }), null, getLocalString("getRows.sheetgroup")));
    }
    else
    {
      getTreeFunction("getRows").setDisplayName(format("getRows.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("getRows").setGroupName(getLocalString("getRows.sheetgroup"));
    }
    if (getTreeFunction("first") == null)
    {
      addChildElement(new TreeFunction("first", "boolean", "first()", format("first.sheet", new Object[] { getDisplayName() }), null, getLocalString("first.sheetgroup")));
    }
    else
    {
      getTreeFunction("first").setDisplayName(format("first.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("first").setGroupName(getLocalString("first.sheetgroup"));
    }
    if (getTreeFunction("afterLast") == null)
    {
      addChildElement(new TreeFunction("afterLast", "void", "afterLast()", format("afterLast.sheet", new Object[] { getDisplayName() }), null, getLocalString("afterLast.sheetgroup")));
    }
    else
    {
      getTreeFunction("afterLast").setDisplayName(format("afterLast.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("afterLast").setGroupName(getLocalString("afterLast.sheetgroup"));
    }
    if (getTreeFunction("previous") == null)
    {
      addChildElement(new TreeFunction("previous", "boolean", "previous()", format("previous.sheet", new Object[] { getDisplayName() }), null, getLocalString("previous.sheetgroup")));
    }
    else
    {
      getTreeFunction("previous").setDisplayName(format("previous.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("previous").setGroupName(getLocalString("previous.sheetgroup"));
    }
    if (getTreeFunction("last") == null)
    {
      addChildElement(new TreeFunction("last", "boolean", "last()", format("last.sheet", new Object[] { getDisplayName() }), null, getLocalString("last.sheetgroup")));
    }
    else
    {
      getTreeFunction("last").setDisplayName(format("last.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("last").setGroupName(getLocalString("last.sheetgroup"));
    }
    if (getTreeFunction("getCurrentRow") == null)
    {
      addChildElement(new TreeFunction("getCurrentRow", "int", "getCurrentRow()", format("getCurrentRow.sheet", new Object[] { getDisplayName() }), null, getLocalString("getCurrentRow.sheetgroup")));
    }
    else
    {
      getTreeFunction("getCurrentRow").setDisplayName(format("getCurrentRow.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("getCurrentRow").setGroupName(getLocalString("getCurrentRow.sheetgroup"));
    }
    if (getTreeFunction("gotoRow") == null)
    {
      addChildElement(new TreeFunction("gotoRow", "int", "gotoRow({arg1})", format("gotoRow.sheet", new Object[] { getDisplayName(), "{arg1}" }), a("int"), getLocalString("gotoRow.sheetgroup")));
    }
    else
    {
      getTreeFunction("gotoRow").setDisplayName(format("gotoRow.sheet", new Object[] { getDisplayName(), "{arg1}" }));
      getTreeFunction("gotoRow").setGroupName(getLocalString("gotoRow.sheetgroup"));
    }
    if (getTreeFunction("insert") == null)
    {
      addChildElement(new TreeFunction("insert", "void", "insert()", format("insert.sheet", new Object[] { getDisplayName() }), null, getLocalString("insert.sheetgroup")));
    }
    else
    {
      getTreeFunction("insert").setDisplayName(format("insert.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("insert").setGroupName(getLocalString("insert.sheetgroup"));
    }
    if (getTreeFunction("delete") == null)
    {
      addChildElement(new TreeFunction("delete", "void", "delete()", format("delete.sheet", new Object[] { getDisplayName() }), null, getLocalString("delete.sheetgroup")));
    }
    else
    {
      getTreeFunction("delete").setDisplayName(format("delete.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("delete").setGroupName(getLocalString("delete.sheetgroup"));
    }
    if (getTreeFunction("resetValues") == null)
    {
      addChildElement(new TreeFunction("resetValues", "void", "resetValues()", format("resetValues.sheet", new Object[] { getDisplayName() }), null, getLocalString("resetValues.sheetgroup")));
    }
    else
    {
      getTreeFunction("resetValues").setDisplayName(format("resetValues.sheet", new Object[] { getDisplayName() }));
      getTreeFunction("resetValues").setGroupName(getLocalString("resetValues.sheetgroup"));
    }
  }

  public TreeAttribute addAttribute(String paramString1, String paramString2, String paramString3)
  {
    TreeAttribute localTreeAttribute = getAttribute(paramString1);
    if (localTreeAttribute == null)
    {
      localTreeAttribute = new TreeAttribute(paramString1, paramString2, paramString3);
      addChildElement(localTreeAttribute);
    }
    return localTreeAttribute;
  }

  public TreeAttribute addAttribute(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    TreeAttribute localTreeAttribute = getAttribute(paramString1);
    if (localTreeAttribute == null)
    {
      localTreeAttribute = new TreeAttribute(paramString1, paramString2, paramString3, paramInt);
      addChildElement(localTreeAttribute);
    }
    return localTreeAttribute;
  }

  public void changeDisplayName(String paramString)
  {
    if (getNodeName().equals(getDisplayName()))
      setNodeName(paramString);
    setDisplayName(paramString);
    getEnvionment().reRegistAllBusinessObject();
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
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
    return (getParent() == null) || (!(getParent() instanceof TreeValueNode));
  }

  public TreeValueNode getRootElement()
  {
    if ((getParent() != null) && ((getParent() instanceof TreeValueNode)))
      return ((TreeValueNode)getParent()).getRootElement();
    return this;
  }

  public TreeValue getTreeValueStatic()
  {
    if ((isRootElement()) && (MemoryShare.getInstance().getTreeValue(getUuid()) != null))
      return MemoryShare.getInstance().getTreeValue(getUuid());
    return null;
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
    if ((localIElement != null) && ((localIElement instanceof TreeValueNode)))
      return ((TreeValueNode)localIElement).getUniqueName() + getDisplayName() + ".";
    return getDisplayName() + ".";
  }

  public String getValueName()
  {
    return getNodeName();
  }

  public String getValueType()
  {
    return "com.flagleader.xml.TreeValue";
  }

  public int getSubPos(TreeAttribute paramTreeAttribute)
  {
    List localList = getFields();
    return localList.indexOf(paramTreeAttribute);
  }

  public int getSubPos(TreeValueNode paramTreeValueNode)
  {
    List localList1 = getFields();
    List localList2 = getAllNodes();
    return localList1.size() + localList2.indexOf(paramTreeValueNode);
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
    if ((paramIElement instanceof TreeAttribute))
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
      localObject1 = new TreeAttribute();
      ((TreeAttribute)localObject1).setKey(localIBusinessObjectEditen1.getValueName());
      ((TreeAttribute)localObject1).setDisplayName(localIBusinessObjectEditen1.getDisplayName());
      ((TreeAttribute)localObject1).changeValueType(localIBusinessObjectEditen1.getValueType());
      ((TreeAttribute)localObject1).setVisible(localIBusinessObjectEditen1.isVisible());
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
        if ((localObject2 instanceof TreeAttribute))
        {
          addChildElement((TreeAttribute)localObject2, paramInt++);
          i = 1;
        }
        else
        {
          if ((!(localObject2 instanceof IVariableObject)) && (!(localObject2 instanceof FieldModel)))
            continue;
          IBusinessObjectEditen localIBusinessObjectEditen2 = (IBusinessObjectEditen)localObject2;
          initUndoable();
          TreeAttribute localTreeAttribute = new TreeAttribute();
          localTreeAttribute.setKey(localIBusinessObjectEditen2.getValueName());
          localTreeAttribute.setDisplayName(localIBusinessObjectEditen2.getDisplayName());
          localTreeAttribute.changeValueType(localIBusinessObjectEditen2.getValueType());
          localTreeAttribute.setVisible(localIBusinessObjectEditen2.isVisible());
          addChildElement(localTreeAttribute, paramInt++);
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
      setModified(true);
      i = 1;
    }
    return i;
  }

  public boolean isEditVisible()
  {
    return true;
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

  public boolean isSingleValue()
  {
    return this.multiType == 0;
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

  public boolean mustWhile()
  {
    return false;
  }

  public IBusinessObjectEditen getNoCaseEditen(String paramString1, String paramString2)
  {
    List localList = getAllEditens();
    for (int i = 0; i < localList.size(); i++)
      if ((((IBusinessObjectEditen)localList.get(i)).getValueName().equalsIgnoreCase(paramString1)) || (((IBusinessObjectEditen)localList.get(i)).getDisplayName().equalsIgnoreCase(paramString2)))
        return (IBusinessObjectEditen)localList.get(i);
    return null;
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
  }

  public String getShowDisplayName()
  {
    if ((getParent() != null) && ((getParent() instanceof TreeValueNode)))
    {
      TreeValueNode localTreeValueNode = getRootElement();
      return getDisplayName() + "(" + localTreeValueNode.getDisplayName() + ")";
    }
    return getDisplayName();
  }

  public int getShareType()
  {
    return this.shareType;
  }

  public void setShareType(int paramInt)
  {
    this.shareType = paramInt;
  }

  private String b(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)paramList.get(i);
      localStringBuffer.append(getFields().indexOf(localTreeAttribute));
      if (i >= paramList.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  private String c(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)paramList.get(i);
      localStringBuffer.append(getTypeManager().g(localTreeAttribute.getJavaType()));
      localStringBuffer.append("{arg").append(i + 1).append("}");
      localStringBuffer.append(getTypeManager().h(localTreeAttribute.getJavaType()));
      if (i >= paramList.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  protected List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    for (int i = 0; i < paramList.size(); i++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)paramList.get(i);
      localArrayList.add(new MethodParam(localTreeAttribute.getValueType(), i));
    }
    return localArrayList;
  }

  private String d(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)paramList.get(i);
      localStringBuffer.append(format("insertParam.sheet", new String[] { localTreeAttribute.getDisplayName(), "{arg" + (i + 1) + "}" }));
      if (i >= paramList.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  public void addInsertFunction(List paramList)
  {
    addChildElement(new TreeFunction("insertValues(" + b(paramList) + ")", "void", "insertValues(new int[]{" + b(paramList) + "},new Object[]{" + c(paramList) + "})", format("insertValues.sheet", new String[] { getDisplayName(), d(paramList) }), a(paramList), true, getLocalString("insertValues.sheetgroup")));
    setModified(true);
  }

  public void addUpdateFunction(List paramList)
  {
    addChildElement(new TreeFunction("updateValues(" + b(paramList) + ")", "void", "updateValues(new int[]{" + b(paramList) + "},new Object[]{" + c(paramList) + "})", format("updateValues.sheet", new String[] { getDisplayName(), d(paramList) }), a(paramList), true, getLocalString("updateValues.sheetgroup")));
    setModified(true);
  }

  public boolean needInit()
  {
    return this.shareType > 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.xml.TreeValueNode
 * JD-Core Version:    0.6.0
 */