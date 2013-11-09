package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.tree.Envionment;
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

public class q extends com.flagleader.builder.dialogs.r
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

  public q(Shell paramShell, Envionment paramEnvionment, int paramInt)
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
    Iterator localIterator = this.a.getEnvionment().getDBModels();
    while (localIterator.hasNext())
    {
      localObject = (DBModel)localIterator.next();
      List localList = ((DBModel)localObject).getAllTables();
      for (int n = 0; n < localList.size(); n++)
      {
        if (!(localList.get(n) instanceof ISelectObject))
          continue;
        a((ISelectObject)localList.get(n));
      }
    }
    this.l.addSelectionListener(new r(this));
    if ((this.k == 1) || (this.k == 2))
    {
      this.j = new Button(localComposite1, 32);
      this.j.setText(a("createselect.LoadTableFieldsDialog"));
    }
    if (this.k == 2)
    {
      this.h = new Button(localComposite1, 32);
      this.h.setText(a("insert.LoadTableFieldsDialog"));
      this.i = new Button(localComposite1, 32);
      this.i.setText(a("update.LoadTableFieldsDialog"));
      this.g = new Button(localComposite1, 32);
      this.g.setText(a("delete.LoadTableFieldsDialog"));
    }
    return (Control)localComposite1;
  }

  private void a(ISelectObject paramISelectObject)
  {
    TreeItem localTreeItem1 = new TreeItem(this.l, 0);
    localTreeItem1.setText(0, paramISelectObject.getDisplayName());
    localTreeItem1.setData(paramISelectObject);
    List localList = paramISelectObject.getFields();
    for (int m = 0; m < localList.size(); m++)
    {
      FieldModel localFieldModel = (FieldModel)localList.get(m);
      TreeItem localTreeItem2 = new TreeItem(localTreeItem1, 0);
      localTreeItem2.setData(localFieldModel);
      localTreeItem2.setText(0, localFieldModel.getDisplayName());
      localTreeItem2.setText(1, localFieldModel.getFieldName());
      localTreeItem2.setText(2, localFieldModel.getValueType());
    }
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem1 = this.l.getItems();
    this.b.clear();
    for (int m = 0; m < arrayOfTreeItem1.length; m++)
    {
      if (!(arrayOfTreeItem1[m].getData() instanceof ISelectObject))
        continue;
      TreeItem[] arrayOfTreeItem2 = arrayOfTreeItem1[m].getItems();
      for (int n = 0; n < arrayOfTreeItem2.length; n++)
      {
        if ((!arrayOfTreeItem2[n].getChecked()) || (!(arrayOfTreeItem2[n].getData() instanceof FieldModel)))
          continue;
        this.b.add(arrayOfTreeItem2[n].getData());
      }
    }
    if ((this.k == 1) || (this.k == 2))
      this.c = this.j.getSelection();
    if (this.k == 2)
    {
      this.d = this.h.getSelection();
      this.e = this.i.getSelection();
      this.f = this.g.getSelection();
    }
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
 * Qualified Name:     com.flagleader.builder.dialogs.e.q
 * JD-Core Version:    0.6.0
 */