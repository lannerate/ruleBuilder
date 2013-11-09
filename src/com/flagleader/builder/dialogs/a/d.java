package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Operation;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.wsdl.extensions.soap.SOAPAddress;
import javax.wsdl.extensions.soap.SOAPOperation;
import javax.xml.namespace.QName;
import org.apache.axis.wsdl.gen.Parser;
import org.apache.axis.wsdl.symbolTable.BindingEntry;
import org.apache.axis.wsdl.symbolTable.Parameter;
import org.apache.axis.wsdl.symbolTable.Parameters;
import org.apache.axis.wsdl.symbolTable.PortEntry;
import org.apache.axis.wsdl.symbolTable.ServiceEntry;
import org.apache.axis.wsdl.symbolTable.SymTabEntry;
import org.apache.axis.wsdl.symbolTable.SymbolTable;
import org.apache.axis.wsdl.toJava.Utils;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class d extends r
{
  private List c = new ArrayList();
  private Text d;
  Parser a;
  Service b;
  private Tree e;

  public d(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddSoapServiceDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(3));
    a(localComposite2).setText(a("url.AddSoapServiceDialog"));
    this.d = super.a(localComposite2, 2048, 380, 12);
    Button localButton = super.a(localComposite2, 8);
    localButton.setText(a("find.AddSoapServiceDialog"));
    localButton.addSelectionListener(new e(this));
    Composite localComposite3 = new Composite(localComposite1, 0);
    localComposite3.setLayout(a(1));
    localComposite3.setLayoutData(a(550, 350));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite1.setLayout(localGridLayout);
    this.e = new s().a(localComposite3, 67618);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.AddSoapServiceDialog");
    while (this.e.getColumnCount() > 0)
      this.e.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".AddSoapServiceDialog");
    for (i = 0; i < arrayOfString2.length; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.e, 8388608);
      localTreeColumn.setText(arrayOfString2[i]);
      if (i == 0)
        localTreeColumn.setWidth(230);
      else
        localTreeColumn.setWidth(150);
    }
    this.e.setLayoutData(new GridData(1808));
    this.e.addSelectionListener(new f(this));
    return localComposite1;
  }

  public List a(Map paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Port localPort = (Port)paramMap.get(str);
      List localList = localPort.getExtensibilityElements();
      for (int i = 0; (localList != null) && (i < localList.size()); i++)
      {
        Object localObject = localList.get(i);
        if (!(localObject instanceof SOAPAddress))
          continue;
        localArrayList.add(localPort);
      }
    }
    return localArrayList;
  }

  private void b()
  {
    this.a = new Parser();
    this.a.run(this.d.getText());
    HashMap localHashMap = this.a.getSymbolTable().getHashMap();
    Iterator localIterator = localHashMap.entrySet().iterator();
    Map.Entry localEntry;
    QName localQName;
    Vector localVector;
    int i;
    SymTabEntry localSymTabEntry;
    Object localObject1;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localQName = (QName)localEntry.getKey();
      localVector = (Vector)localEntry.getValue();
      for (i = 0; i < localVector.size(); i++)
      {
        localSymTabEntry = (SymTabEntry)localVector.elementAt(i);
        if (!ServiceEntry.class.isInstance(localSymTabEntry))
          continue;
        this.b = ((ServiceEntry)localSymTabEntry).getService();
        localObject1 = a(this.b.getPorts());
        for (int j = 0; j < ((List)localObject1).size(); j++)
        {
          localObject2 = (Port)((List)localObject1).get(j);
          TreeItem localTreeItem2 = new TreeItem(this.e, 0);
          localTreeItem2.setText(0, this.b.getQName().getLocalPart());
          localTreeItem2.setData(localObject2);
          List localList = ((Port)localObject2).getBinding().getBindingOperations();
          for (int m = 0; m < localList.size(); m++)
            a((BindingOperation)localList.get(m), localTreeItem2);
        }
        if (this.e.getItemCount() > 0)
          return;
      }
    }
    localIterator = localHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localQName = (QName)localEntry.getKey();
      localVector = (Vector)localEntry.getValue();
      for (i = 0; i < localVector.size(); i++)
      {
        localSymTabEntry = (SymTabEntry)localVector.elementAt(i);
        if (!PortEntry.class.isInstance(localSymTabEntry))
          continue;
        localObject1 = ((PortEntry)localSymTabEntry).getPort();
        TreeItem localTreeItem1 = new TreeItem(this.e, 0);
        localTreeItem1.setText(0, localQName.getLocalPart());
        localTreeItem1.setData(localObject1);
        localObject2 = ((Port)localObject1).getBinding().getBindingOperations();
        for (int k = 0; k < ((List)localObject2).size(); k++)
          a((BindingOperation)((List)localObject2).get(k), localTreeItem1);
        return;
      }
    }
  }

  private void a(BindingOperation paramBindingOperation, TreeItem paramTreeItem)
  {
    TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setText(0, paramBindingOperation.getName());
    localTreeItem.setData(paramBindingOperation);
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem = this.e.getItems();
    this.c.clear();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if (!(arrayOfTreeItem[i].getData() instanceof Port))
        continue;
      a(arrayOfTreeItem[i]);
    }
    super.okPressed();
  }

  private void a(TreeItem paramTreeItem)
  {
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    String str1 = "";
    String str2 = "";
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if ((!arrayOfTreeItem[i].getChecked()) || (!(arrayOfTreeItem[i].getData() instanceof BindingOperation)))
        continue;
      Port localPort = (Port)paramTreeItem.getData();
      BindingOperation localBindingOperation = (BindingOperation)arrayOfTreeItem[i].getData();
      List localList = localBindingOperation.getExtensibilityElements();
      for (int j = 0; j < localList.size(); j++)
      {
        if (!(localList.get(j) instanceof SOAPOperation))
          continue;
        str1 = ((SOAPOperation)localList.get(j)).getSoapActionURI();
        if (((SOAPOperation)localList.get(j)).getElementType().getNamespaceURI().indexOf("soap12") > 0)
          str2 = "1.2";
        else
          str2 = "1.1";
      }
      Vector localVector1 = new Vector();
      Vector localVector2 = new Vector();
      Vector localVector3 = new Vector();
      SymbolTable localSymbolTable = this.a.getSymbolTable();
      BindingEntry localBindingEntry = localSymbolTable.getBindingEntry(localPort.getBinding().getQName());
      Parameters localParameters = null;
      Iterator localIterator = localBindingEntry.getParameters().keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Operation)localIterator.next();
        if (!((Operation)localObject1).getName().equals(localBindingOperation.getName()))
          continue;
        localParameters = (Parameters)localBindingEntry.getParameters().get(localObject1);
        break;
      }
      if (localParameters == null)
        throw new RuntimeException(localBindingOperation.getName() + " was not found.");
      Object localObject1 = null;
      if (localParameters.returnParam != null)
      {
        localObject1 = Utils.getXSIType(localParameters.returnParam);
        localObject2 = localParameters.returnParam.getQName();
        localVector1.add(((QName)localObject2).getLocalPart());
      }
      Object localObject2 = new SoapService(paramTreeItem.getText(0) + "_" + arrayOfTreeItem[i].getText(0));
      ((SoapService)localObject2).setEndpointURL(this.d.getText());
      ((SoapService)localObject2).setServiceNS(localBindingEntry.getQName().getNamespaceURI());
      ((SoapService)localObject2).setOperationName(localBindingOperation.getName());
      ((SoapService)localObject2).setActionUrl(str1);
      ((SoapService)localObject2).setServiceName(this.b.getQName().getLocalPart());
      ((SoapService)localObject2).setPortName(localPort.getName());
      ((SoapService)localObject2).setSoapVersion(str2);
      ((SoapService)localObject2).setNodeName("soap" + paramTreeItem.getText(0) + "_" + arrayOfTreeItem[i].getText(0));
      if (localObject1 != null)
        ((SoapService)localObject2).setResultType(((QName)localObject1).getLocalPart());
      for (int k = 0; k < localParameters.list.size(); k++)
      {
        Parameter localParameter = (Parameter)localParameters.list.get(k);
        SoapParameter localSoapParameter = new SoapParameter();
        localSoapParameter.setKey(localParameter.getName());
        localSoapParameter.setDisplayName(localParameter.getQName().getLocalPart());
        if (localParameter.getQName().getNamespaceURI() != null)
          ((SoapService)localObject2).setParamNS(localParameter.getQName().getNamespaceURI());
        localSoapParameter.setRetType(localParameter.getMode());
        localSoapParameter.setValueType(Utils.getXSIType(localParameter).getLocalPart());
        ((SoapService)localObject2).addChildElement(localSoapParameter);
      }
      this.c.add(localObject2);
    }
  }

  public List a()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.d
 * JD-Core Version:    0.6.0
 */