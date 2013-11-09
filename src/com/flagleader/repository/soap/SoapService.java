package com.flagleader.repository.soap;

import com.flagleader.engine.Property;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.BusinessObjectMethod;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.AbstractBOContainer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.soap.ISoap;
import com.flagleader.soap.SoapFactory;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SoapService extends AbstractBOContainer
  implements IBusinessObjectContainer, IBusinessObject
{
  public static final String NAME = "SoapService";
  private String nodeName;
  private String resultType = "";
  private String endpointURL = "";
  private String serviceNS = "";
  private String serviceName = "";
  private String portName = "";
  private String operationName = "";
  private String actionUrl = "";
  private String soapVersion = "";
  private String paramNS = "";
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

  public SoapService(SoapService paramSoapService)
  {
    super(paramSoapService);
    this.resultType = paramSoapService.resultType;
    this.nodeName = paramSoapService.nodeName;
    this.loadType = paramSoapService.loadType;
    this.endpointURL = paramSoapService.endpointURL;
    this.serviceNS = paramSoapService.serviceNS;
    this.serviceName = paramSoapService.serviceName;
    this.portName = paramSoapService.portName;
    this.operationName = paramSoapService.operationName;
    this.actionUrl = paramSoapService.actionUrl;
    this.soapVersion = paramSoapService.soapVersion;
    this.paramNS = paramSoapService.paramNS;
  }

  public SoapService()
  {
  }

  public SoapService(String paramString)
  {
    super(paramString);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSoapService(this);
  }

  public String getName()
  {
    return "SoapService";
  }

  public IElement deepClone()
  {
    return new SoapService(this);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    return false;
  }

  public boolean acceptNode(String paramString)
  {
    return false;
  }

  public ITreeNode createChildNode(String paramString)
  {
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
    return ((paramIElement instanceof SoapParameter)) || ((paramIElement instanceof SoapFunction)) || ((paramIElement instanceof BusinessObjectMethod));
  }

  public ISoap getSoapInstance()
  {
    List localList = getAllAttributes();
    String[] arrayOfString1 = new String[localList.size()];
    String[] arrayOfString2 = new String[localList.size()];
    String[] arrayOfString3 = new String[localList.size()];
    int[] arrayOfInt = new int[localList.size()];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      SoapParameter localSoapParameter = (SoapParameter)localList.get(i);
      arrayOfString1[i] = localSoapParameter.getValueName();
      arrayOfString2[i] = localSoapParameter.getDisplayName();
      arrayOfString3[i] = localSoapParameter.getValueType();
      arrayOfInt[i] = localSoapParameter.getRetType();
    }
    ISoap localISoap = SoapFactory.newIntance().getSoap(arrayOfString1, arrayOfString2, arrayOfString3, arrayOfInt, this.resultType, this.endpointURL, this.serviceNS, this.actionUrl, this.portName, this.operationName, this.serviceName);
    localISoap.setSoapVersion(this.soapVersion);
    if ((this.paramNS != null) && (this.paramNS.length() > 0))
      localISoap.setParamNS(this.paramNS);
    return localISoap;
  }

  public String getVarName()
  {
    if (StringUtil.isJavaIdentifier(getNodeName()))
      return getNodeName();
    return "soap" + getParent().getElementPos(this);
  }

  public SoapFunction getSoapFunction(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof SoapFunction)) && (((SoapFunction)localObject).getValueName().equals(paramString)))
        return (SoapFunction)localObject;
    }
    return null;
  }

  protected SoapParameter a(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof SoapParameter)) && (((SoapParameter)localObject).getKey().equals(paramString)))
        return (SoapParameter)localObject;
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
      if (!(localObject instanceof SoapFunction))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public List getAllKeys()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.nodeName);
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      (localObject instanceof SoapParameter);
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
      if (!(localObject instanceof SoapParameter))
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
      if (!(localObject instanceof SoapService))
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
    if (getSoapFunction("invoke") == null)
      addChildElement(new SoapFunction("invoke", "object", "invoke()", format("invoke.soap", new Object[] { getDisplayName() }), null));
    else
      getSoapFunction("invoke").setDisplayName(format("invoke.soap", new Object[] { getDisplayName() }));
    if (getSoapFunction("resetValues") == null)
      addChildElement(new SoapFunction("resetValues", "void", "resetValues()", format("resetValues.soap", new Object[] { getDisplayName() }), null));
    else
      getSoapFunction("resetValues").setDisplayName(format("resetValues.soap", new Object[] { getDisplayName() }));
    if (!StringUtil.isEmpty(getResultType()))
      if (getSoapFunction("getReturnValue") == null)
        addChildElement(new SoapFunction("getReturnValue", getResultType(), "get" + getTypeManager().a(getResultType()).N() + "(\"\")", format("getReturnValue.soap", new Object[] { getDisplayName() }), null));
      else
        getSoapFunction("getReturnValue").setDisplayName(format("getReturnValue.soap", new Object[] { getDisplayName() }));
  }

  public SoapParameter addParameter(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    SoapParameter localSoapParameter = a(paramString1);
    if (localSoapParameter == null)
    {
      localSoapParameter = new SoapParameter(paramString1, paramString2, paramString3, paramInt);
      addChildElement(localSoapParameter);
    }
    return localSoapParameter;
  }

  public SoapFunction getExecuteFunction()
  {
    if (getSoapFunction("getReturnValue") == null)
      updateFunction();
    return getSoapFunction("getReturnValue");
  }

  public void changeValueType(String paramString)
  {
    setResultType(paramString);
    getExecuteFunction().setValueType(paramString);
    getExecuteFunction().setVariableName("get" + getTypeManager().a(getResultType()).N() + "(\"\")");
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public String getResultType()
  {
    return this.resultType;
  }

  public void setResultType(String paramString)
  {
    this.resultType = paramString;
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
    return (getParent() == null) || (!(getParent() instanceof SoapService));
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
    return getVarName();
  }

  public String getValueName()
  {
    return getVarName();
  }

  public String getValueType()
  {
    return "com.flagleader.soap.ISoap";
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
    for (int i = 0; i < paramList.size(); i++)
    {
      ((IBusinessObject)paramList.get(i)).setVisible(true);
      addChildElement((IBusinessObject)paramList.get(i));
    }
    return false;
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

  public String getEndpointURL()
  {
    return this.endpointURL;
  }

  public void setEndpointURL(String paramString)
  {
    this.endpointURL = paramString;
  }

  public String getServiceNS()
  {
    return this.serviceNS;
  }

  public void setServiceNS(String paramString)
  {
    this.serviceNS = paramString;
  }

  public String getServiceName()
  {
    return this.serviceName;
  }

  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }

  public void setModified(boolean paramBoolean)
  {
    super.setModified(paramBoolean);
    if ((paramBoolean) && (getEnvionment() != null))
      getEnvionment().setModified(true);
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
  }

  public String getPortName()
  {
    return this.portName;
  }

  public void setPortName(String paramString)
  {
    this.portName = paramString;
  }

  public String getOperationName()
  {
    return this.operationName;
  }

  public void setOperationName(String paramString)
  {
    this.operationName = paramString;
  }

  public String getActionUrl()
  {
    return this.actionUrl;
  }

  public void setActionUrl(String paramString)
  {
    this.actionUrl = paramString;
  }

  public String getSoapVersion()
  {
    return this.soapVersion;
  }

  public void setSoapVersion(String paramString)
  {
    this.soapVersion = paramString;
  }

  public String getParamNS()
  {
    return this.paramNS;
  }

  public void setParamNS(String paramString)
  {
    this.paramNS = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.soap.SoapService
 * JD-Core Version:    0.6.0
 */