package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.Envionment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class o extends r
{
  private Envionment a = null;
  private List b = new ArrayList();
  private int c;
  private Tree d;

  public o(Shell paramShell, Envionment paramEnvionment, int paramInt)
  {
    super(paramShell);
    this.a = paramEnvionment;
    this.c = paramInt;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadSoapParameterDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(550, 350));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite1.setLayout(localGridLayout);
    this.d = new s().a(localComposite2, 67618);
    this.d.setLayoutData(new GridData(1808));
    this.d.setHeaderVisible(true);
    this.d.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadSoapParameterDialog");
    while (this.d.getColumnCount() > 0)
      this.d.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".LoadSoapParameterDialog");
    Object localObject;
    for (i = 0; i < arrayOfString2.length; i++)
    {
      localObject = new TreeColumn(this.d, 8388608);
      ((TreeColumn)localObject).setText(arrayOfString2[i]);
      if (i == 0)
        ((TreeColumn)localObject).setWidth(230);
      else
        ((TreeColumn)localObject).setWidth(150);
    }
    this.d.setLayoutData(new GridData(1808));
    Iterator localIterator = this.a.getSoapServices();
    while (localIterator.hasNext())
    {
      localObject = (SoapService)localIterator.next();
      TreeItem localTreeItem = new TreeItem(this.d, 0);
      localTreeItem.setText(0, ((SoapService)localObject).getDisplayName());
      localTreeItem.setData(localObject);
      List localList = ((SoapService)localObject).getAllAttributes();
      for (int j = 0; j < localList.size(); j++)
        a((SoapParameter)localList.get(j), localTreeItem);
    }
    this.d.addSelectionListener(new p(this));
    return (Control)localComposite1;
  }

  private void a(SoapParameter paramSoapParameter, TreeItem paramTreeItem)
  {
    TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setText(0, paramSoapParameter.getDisplayName());
    localTreeItem.setText(1, paramSoapParameter.getValueName());
    localTreeItem.setText(2, paramSoapParameter.getValueType());
    localTreeItem.setData(paramSoapParameter);
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem = this.d.getItems();
    this.b.clear();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if (!(arrayOfTreeItem[i].getData() instanceof SoapService))
        continue;
      a(arrayOfTreeItem[i]);
    }
    super.okPressed();
  }

  private void a(TreeItem paramTreeItem)
  {
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if ((!arrayOfTreeItem[i].getChecked()) || (!(arrayOfTreeItem[i].getData() instanceof SoapParameter)))
        continue;
      this.b.add(arrayOfTreeItem[i].getData());
    }
  }

  public List a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.o
 * JD-Core Version:    0.6.0
 */