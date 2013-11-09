package com.flagleader.builder.a.b;

import com.flagleader.a.B;
import com.flagleader.a.y;
import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bs;
import com.flagleader.builder.a.bu;
import com.flagleader.engine.IRuleLog;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.I;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.soap.ISoap;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class aB extends aS
  implements bs, IElementViewer
{
  private Table f;
  private TableItem g;
  private TableEditor q;
  private HashMap r = new HashMap();
  private aI s;
  private HashMap t;
  private IRuleLog u;
  int e = 0;

  private Object a(String paramString)
  {
    return this.r.get(paramString);
  }

  public aB(SoapService paramSoapService, Composite paramComposite, bu parambu)
  {
    super(paramSoapService, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new aB((SoapService)this.c, paramComposite, this.a);
  }

  protected SoapService e()
  {
    return (SoapService)this.c;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.f = new Table(localComposite, 65536);
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    this.f.setLayoutData(localGridData);
    this.f.setHeaderVisible(true);
    this.f.setLinesVisible(true);
    f();
    this.f.setVisible(true);
    this.f.addMouseListener(new aF(this));
    return localComposite;
  }

  protected void h()
  {
    a(new aE(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "go");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.f.removeAll();
    Control[] arrayOfControl = this.f.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    g();
    super.update();
  }

  public boolean needUpdate()
  {
    return this.d == 0L;
  }

  private void f()
  {
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("displayName.test"));
    localTableColumn.setWidth(80);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("Type.test"));
    localTableColumn.setWidth(80);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("InitialValue.test"));
    localTableColumn.setWidth(110);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("ResultValue.test"));
    localTableColumn.setWidth(110);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("AttributeName.Test"));
    localTableColumn.setWidth(80);
  }

  private void g()
  {
    List localList = e().getAllAttributes();
    for (int i = 0; i < localList.size(); i++)
    {
      TableItem localTableItem2 = new TableItem(this.f, 8);
      SoapParameter localSoapParameter = (SoapParameter)localList.get(i);
      a(localTableItem2, localSoapParameter.getDisplayName(), localSoapParameter.getValueType(), localSoapParameter.getValueName());
    }
    TableItem localTableItem1 = new TableItem(this.f, 8);
    a(localTableItem1, "return", "string", "result");
  }

  public void a_()
  {
    this.e = 0;
    this.s = new aI(this);
    z();
    a(this.s, false, true);
    C();
    a().getShell().setCursor(a().getShell().getDisplay().getSystemCursor(3));
    aC localaC = new aC(this);
    this.s.start();
    Display.getCurrent().timerExec(100, localaC);
  }

  public void a(ISoap paramISoap)
  {
    this.p = this.e;
    b(this.p);
    z();
    this.f.getDisplay().asyncExec(new aD(this, paramISoap));
  }

  private void a(TableItem paramTableItem, String paramString1, String paramString2, String paramString3)
  {
    paramTableItem.setText(0, paramString1);
    paramTableItem.setText(1, paramString2);
    paramTableItem.setText(4, paramString3);
    if (this.r.get(paramString3) != null)
      paramTableItem.setText(2, this.r.get(paramString3).toString());
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  private int a(B paramB, y paramy)
  {
    if (paramy.l())
      return 1;
    if ((paramy.j()) || (paramy.k()))
      try
      {
        PropertyDescriptor localPropertyDescriptor = PropertyUtils.getPropertyDescriptor(paramB.V().newInstance(), paramy.N());
        if ((PropertyUtils.getReadMethod(localPropertyDescriptor) != null) && (PropertyUtils.getWriteMethod(localPropertyDescriptor) != null))
          return 2;
      }
      catch (Exception localException)
      {
        return 0;
      }
    return 0;
  }

  public String getCompositeUuid()
  {
    return this.c.getEditUuid() + "test";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aB
 * JD-Core Version:    0.6.0
 */