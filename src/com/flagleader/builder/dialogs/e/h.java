package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
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

public class h extends r
{
  private Envionment c = null;
  private List d = new ArrayList();
  private int e = 0;
  public static final int a = 0;
  public static final int b = 1;
  private Tree f;

  public h(Shell paramShell, Envionment paramEnvionment)
  {
    super(paramShell);
    this.c = paramEnvionment;
  }

  public h(Shell paramShell, Envionment paramEnvionment, int paramInt)
  {
    super(paramShell);
    this.c = paramEnvionment;
    this.e = paramInt;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadAssignVariablesDialog"));
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
    this.f = new s().a(localComposite2, 67618);
    this.f.setLayoutData(new GridData(1808));
    this.f.setHeaderVisible(true);
    this.f.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadAssignVariablesDialog");
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".LoadAssignVariablesDialog");
    for (i = 0; i < arrayOfString2.length; i++)
    {
      localObject1 = new TreeColumn(this.f, 8388608);
      ((TreeColumn)localObject1).setText(arrayOfString2[i]);
      if (i == 0)
        ((TreeColumn)localObject1).setWidth(230);
      else
        ((TreeColumn)localObject1).setWidth(150);
    }
    this.f.setLayoutData(new GridData(1808));
    Iterator localIterator = this.c.getEnvionment().getTreeNodes();
    while (localIterator.hasNext())
    {
      localObject1 = (TreeValueNode)localIterator.next();
      localObject2 = new TreeItem(this.f, 0);
      a((TreeValueNode)localObject1, (TreeItem)localObject2);
    }
    Object localObject1 = this.c.getEnvionment().getAcceptElements(new i(this));
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IBusinessObjectContainer)((Iterator)localObject1).next();
      TreeItem localTreeItem = new TreeItem(this.f, 0);
      a((IBusinessObjectContainer)localObject2, localTreeItem);
    }
    this.f.addSelectionListener(new j(this));
    Object localObject2 = new Button(localComposite1, 32);
    ((Button)localObject2).setText(a("selectall.LoadAssignVariablesDialog"));
    ((Button)localObject2).addSelectionListener(new k(this, (Button)localObject2));
    return (Control)(Control)localComposite1;
  }

  private void a(TreeItem paramTreeItem)
  {
    if (paramTreeItem.getParentItem() != null)
    {
      paramTreeItem.getParentItem().setChecked(false);
      a(paramTreeItem.getParentItem());
    }
  }

  private void a(TreeItem[] paramArrayOfTreeItem, boolean paramBoolean)
  {
    for (int i = 0; (paramArrayOfTreeItem != null) && (i < paramArrayOfTreeItem.length); i++)
    {
      paramArrayOfTreeItem[i].setChecked(paramBoolean);
      a(paramArrayOfTreeItem[i].getItems(), paramBoolean);
    }
  }

  private void a(TreeValueNode paramTreeValueNode, TreeItem paramTreeItem)
  {
    paramTreeItem.setText(0, paramTreeValueNode.getDisplayName());
    paramTreeItem.setData(paramTreeValueNode);
    if (this.e == 1)
      paramTreeItem.setChecked(true);
    List localList1 = paramTreeValueNode.getFields();
    for (int i = 0; i < localList1.size(); i++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)localList1.get(i);
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      localTreeItem.setData(localTreeAttribute);
      localTreeItem.setText(0, localTreeAttribute.getDisplayName());
      localTreeItem.setText(1, localTreeAttribute.getValueName());
      localTreeItem.setText(2, localTreeAttribute.getValueType());
      if (this.e != 1)
        continue;
      localTreeItem.setChecked(true);
    }
    List localList2 = paramTreeValueNode.getAllNodes();
    for (int j = 0; j < localList2.size(); j++)
    {
      if (!(localList2.get(j) instanceof TreeValueNode))
        continue;
      a((TreeValueNode)localList2.get(j), new TreeItem(paramTreeItem, 0));
    }
  }

  private void a(IBusinessObjectContainer paramIBusinessObjectContainer, TreeItem paramTreeItem)
  {
    paramTreeItem.setText(0, paramIBusinessObjectContainer.getDisplayName());
    paramTreeItem.setData(paramIBusinessObjectContainer);
    if (this.e == 1)
      paramTreeItem.setChecked(true);
    List localList = paramIBusinessObjectContainer.getAllEditens();
    for (int i = 0; i < localList.size(); i++)
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localList.get(i);
      if (!(localIBusinessObjectEditen instanceof IVariableObject))
        continue;
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      localTreeItem.setData(localIBusinessObjectEditen);
      localTreeItem.setText(0, localIBusinessObjectEditen.getDisplayName());
      localTreeItem.setText(1, localIBusinessObjectEditen.getValueName());
      localTreeItem.setText(2, localIBusinessObjectEditen.getValueType());
      if (this.e != 1)
        continue;
      localTreeItem.setChecked(true);
    }
  }

  private void a(TreeItem[] paramArrayOfTreeItem)
  {
    for (int i = 0; i < paramArrayOfTreeItem.length; i++)
      if ((paramArrayOfTreeItem[i].getData() instanceof IBusinessObjectContainer))
      {
        a(paramArrayOfTreeItem[i].getItems());
      }
      else
      {
        if ((!paramArrayOfTreeItem[i].getChecked()) || (!(paramArrayOfTreeItem[i].getData() instanceof IVariableObject)))
          continue;
        this.d.add(paramArrayOfTreeItem[i].getData());
      }
  }

  protected void okPressed()
  {
    this.d.clear();
    a(this.f.getItems());
    super.okPressed();
  }

  public List a()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.h
 * JD-Core Version:    0.6.0
 */