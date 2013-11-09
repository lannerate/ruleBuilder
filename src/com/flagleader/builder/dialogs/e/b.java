package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class b extends r
{
  private Envionment a = null;
  private List b = new ArrayList();
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private Button g;
  private Button h;
  private Button i;
  private Button j;
  private int k = 0;
  private Tree l;

  public b(Shell paramShell, Envionment paramEnvionment, int paramInt)
  {
    super(paramShell);
    this.a = paramEnvionment;
    this.k = paramInt;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadTableFieldsDialog"));
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
    this.l = new s().a(localComposite2, 67618);
    this.l.setLayoutData(new GridData(1808));
    this.l.setHeaderVisible(true);
    this.l.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadTableFieldsDialog");
    while (this.l.getColumnCount() > 0)
      this.l.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int m = 0; m < arrayOfString1.length; m++)
      arrayOfString2[m] = ResourceTools.getMessage(arrayOfString1[m] + ".LoadTableFieldsDialog");
    Object localObject;
    for (m = 0; m < arrayOfString2.length; m++)
    {
      localObject = new TreeColumn(this.l, 8388608);
      ((TreeColumn)localObject).setText(arrayOfString2[m]);
      if (m == 0)
        ((TreeColumn)localObject).setWidth(230);
      else
        ((TreeColumn)localObject).setWidth(150);
    }
    this.l.setLayoutData(new GridData(1808));
    Iterator localIterator = this.a.getEnvionment().getTreeNodes();
    while (localIterator.hasNext())
    {
      localObject = (TreeValueNode)localIterator.next();
      TreeItem localTreeItem = new TreeItem(this.l, 0);
      a((TreeValueNode)localObject, localTreeItem);
    }
    this.l.addSelectionListener(new c(this));
    return (Control)localComposite1;
  }

  private void a(TreeItem[] paramArrayOfTreeItem, boolean paramBoolean)
  {
    for (int m = 0; (paramArrayOfTreeItem != null) && (m < paramArrayOfTreeItem.length); m++)
    {
      paramArrayOfTreeItem[m].setChecked(paramBoolean);
      a(paramArrayOfTreeItem[m].getItems(), paramBoolean);
    }
  }

  private void a(TreeValueNode paramTreeValueNode, TreeItem paramTreeItem)
  {
    paramTreeItem.setText(0, paramTreeValueNode.getDisplayName());
    paramTreeItem.setData(paramTreeValueNode);
    List localList1 = paramTreeValueNode.getFields();
    for (int m = 0; m < localList1.size(); m++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)localList1.get(m);
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      localTreeItem.setData(localTreeAttribute);
      localTreeItem.setText(0, localTreeAttribute.getDisplayName());
      localTreeItem.setText(1, localTreeAttribute.getValueName());
      localTreeItem.setText(2, localTreeAttribute.getValueType());
    }
    List localList2 = paramTreeValueNode.getAllNodes();
    for (int n = 0; n < localList2.size(); n++)
    {
      if (!(localList2.get(n) instanceof TreeValueNode))
        continue;
      a((TreeValueNode)localList2.get(n), new TreeItem(paramTreeItem, 0));
    }
  }

  private void a(TreeItem paramTreeItem)
  {
    if (paramTreeItem.getChecked())
      this.b.add(paramTreeItem.getData());
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int m = 0; m < arrayOfTreeItem.length; m++)
      a(arrayOfTreeItem[m]);
  }

  protected void okPressed()
  {
    this.b.clear();
    TreeItem[] arrayOfTreeItem = this.l.getItems();
    for (int m = 0; m < arrayOfTreeItem.length; m++)
      a(arrayOfTreeItem[m]);
    super.okPressed();
  }

  public List a()
  {
    return this.b;
  }

  public boolean b()
  {
    return this.f;
  }

  public boolean c()
  {
    return this.d;
  }

  public boolean d()
  {
    return this.e;
  }

  public boolean e()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.b
 * JD-Core Version:    0.6.0
 */