package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.tree.Envionment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class w extends r
{
  private Envionment a = null;
  private List b = new ArrayList();
  private Tree c;

  public w(Shell paramShell, Envionment paramEnvionment)
  {
    super(paramShell);
    this.a = paramEnvionment;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadTableListDialog"));
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
    this.c = new s().a(localComposite2, 68386);
    this.c.setLayoutData(new GridData(1808));
    this.c.setHeaderVisible(true);
    this.c.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadTableListDialog");
    while (this.c.getColumnCount() > 0)
      this.c.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".LoadTableListDialog");
    Object localObject;
    for (i = 0; i < arrayOfString2.length; i++)
    {
      localObject = new TreeColumn(this.c, 8388608);
      ((TreeColumn)localObject).setText(arrayOfString2[i]);
      if (i == 0)
        ((TreeColumn)localObject).setWidth(80);
      else
        ((TreeColumn)localObject).setWidth(150);
    }
    this.c.setLayoutData(new GridData(1808));
    Iterator localIterator = this.a.getAcceptElements(new x(this));
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof IBOAndContainer))
        continue;
      a((IBOAndContainer)localObject);
    }
    this.c.addSelectionListener(new y(this));
    for (int j = 0; j < this.c.getColumnCount(); j++)
      this.c.getColumn(j).pack();
    return (Control)localComposite1;
  }

  private void a(IBOAndContainer paramIBOAndContainer)
  {
    TreeItem localTreeItem1 = new TreeItem(this.c, 0);
    localTreeItem1.setText(1, paramIBOAndContainer.getDisplayName());
    localTreeItem1.setData(paramIBOAndContainer);
    List localList;
    int i;
    Object localObject;
    TreeItem localTreeItem2;
    if ((paramIBOAndContainer instanceof ISelectObject))
    {
      localList = ((ISelectObject)paramIBOAndContainer).getFields();
      for (i = 0; i < localList.size(); i++)
      {
        localObject = (FieldModel)localList.get(i);
        localTreeItem2 = new TreeItem(localTreeItem1, 0);
        localTreeItem2.setData(localObject);
        localTreeItem2.setText(0, i);
        localTreeItem2.setText(1, ((FieldModel)localObject).getDisplayName());
        localTreeItem2.setText(2, ((FieldModel)localObject).getFieldName());
        localTreeItem2.setText(3, ((FieldModel)localObject).getValueType());
      }
    }
    else if ((paramIBOAndContainer instanceof SheetTable))
    {
      localList = ((SheetTable)paramIBOAndContainer).getFields();
      for (i = 0; i < localList.size(); i++)
      {
        localObject = (SheetFieldModel)localList.get(i);
        localTreeItem2 = new TreeItem(localTreeItem1, 0);
        localTreeItem2.setData(localObject);
        localTreeItem2.setText(0, i);
        localTreeItem2.setText(1, ((SheetFieldModel)localObject).getDisplayName());
        localTreeItem2.setText(2, ((SheetFieldModel)localObject).getFieldName().toLowerCase());
        localTreeItem2.setText(3, ((SheetFieldModel)localObject).getValueType());
      }
    }
    localTreeItem1.setExpanded(true);
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem1 = this.c.getItems();
    this.b.clear();
    Object localObject1 = null;
    for (int i = 0; i < arrayOfTreeItem1.length; i++)
    {
      Object localObject2;
      TreeItem[] arrayOfTreeItem2;
      int j;
      if ((arrayOfTreeItem1[i].getData() instanceof ISelectObject))
      {
        localObject2 = (ISelectObject)arrayOfTreeItem1[i].getData();
        arrayOfTreeItem2 = arrayOfTreeItem1[i].getItems();
        for (j = 0; j < arrayOfTreeItem2.length; j++)
        {
          if ((!arrayOfTreeItem2[j].getChecked()) || (!(arrayOfTreeItem2[j].getData() instanceof FieldModel)))
            continue;
          if (localObject1 == null)
          {
            localObject1 = localObject2;
          }
          else if (!localObject1.equals(localObject2))
          {
            MessageDialog.openError(getShell(), "", a("error.LoadTableListDialog"));
            return;
          }
          this.b.add(new z(this, arrayOfTreeItem2[j].getText(0), (FieldModel)arrayOfTreeItem2[j].getData()));
        }
      }
      else
      {
        if (!(arrayOfTreeItem1[i].getData() instanceof SheetTable))
          continue;
        localObject2 = (SheetTable)arrayOfTreeItem1[i].getData();
        arrayOfTreeItem2 = arrayOfTreeItem1[i].getItems();
        for (j = 0; j < arrayOfTreeItem2.length; j++)
        {
          if ((!arrayOfTreeItem2[j].getChecked()) || (!(arrayOfTreeItem2[j].getData() instanceof SheetFieldModel)))
            continue;
          if (localObject1 == null)
          {
            localObject1 = localObject2;
          }
          else if (!localObject1.equals(localObject2))
          {
            MessageDialog.openError(getShell(), "", a("error.LoadTableListDialog"));
            return;
          }
          this.b.add(new z(this, arrayOfTreeItem2[j].getText(0), (SheetFieldModel)arrayOfTreeItem2[j].getData()));
        }
      }
    }
    super.okPressed();
  }

  public List a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.w
 * JD-Core Version:    0.6.0
 */