package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.ArrayList;
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

public class A extends r
{
  private TreeValueNode a = null;
  private List b = new ArrayList();
  private boolean c = false;
  private Button d;
  private Tree e;

  public A(Shell paramShell, TreeValueNode paramTreeValueNode)
  {
    super(paramShell);
    this.a = paramTreeValueNode;
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
    this.e = new s().a(localComposite2, 67618);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadTableFieldsDialog");
    while (this.e.getColumnCount() > 0)
      this.e.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".LoadTableFieldsDialog");
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
    a(this.a);
    this.e.addSelectionListener(new B(this));
    this.d = new Button(localComposite1, 32);
    this.d.setText(a("insert.LoadTableFieldsDialog"));
    this.d.setSelection(true);
    return localComposite1;
  }

  private void a(TreeValueNode paramTreeValueNode)
  {
    TreeItem localTreeItem1 = new TreeItem(this.e, 0);
    localTreeItem1.setText(0, paramTreeValueNode.getDisplayName());
    localTreeItem1.setData(paramTreeValueNode);
    List localList = paramTreeValueNode.getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)localList.get(i);
      TreeItem localTreeItem2 = new TreeItem(localTreeItem1, 0);
      localTreeItem2.setData(localTreeAttribute);
      localTreeItem2.setText(0, localTreeAttribute.getDisplayName());
      localTreeItem2.setText(1, localTreeAttribute.getKey());
      localTreeItem2.setText(2, localTreeAttribute.getValueType());
    }
    localTreeItem1.setExpanded(true);
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem1 = this.e.getItems();
    this.b.clear();
    for (int i = 0; i < arrayOfTreeItem1.length; i++)
    {
      if (!(arrayOfTreeItem1[i].getData() instanceof TreeValueNode))
        continue;
      TreeItem[] arrayOfTreeItem2 = arrayOfTreeItem1[i].getItems();
      for (int j = 0; j < arrayOfTreeItem2.length; j++)
      {
        if ((!arrayOfTreeItem2[j].getChecked()) || (!(arrayOfTreeItem2[j].getData() instanceof TreeAttribute)))
          continue;
        this.b.add(arrayOfTreeItem2[j].getData());
      }
    }
    this.c = this.d.getSelection();
    super.okPressed();
  }

  public List a()
  {
    return this.b;
  }

  public boolean b()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.A
 * JD-Core Version:    0.6.0
 */