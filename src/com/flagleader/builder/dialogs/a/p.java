package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.IBusinessObjectEditen;
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

public class p extends r
{
  private Envionment a = null;
  private List b = new ArrayList();
  private Tree c;

  public p(Shell paramShell, Envionment paramEnvionment)
  {
    super(paramShell);
    this.a = paramEnvionment;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadEnvionmentDialog"));
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
    this.c = new s().a(localComposite2, 67616);
    this.c.setLayoutData(new GridData(1808));
    this.c.setHeaderVisible(true);
    this.c.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadEnvionmentDialog");
    while (this.c.getColumnCount() > 0)
      this.c.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".LoadEnvionmentDialog");
    for (i = 0; i < arrayOfString2.length; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.c, 8388608);
      localTreeColumn.setText(arrayOfString2[i]);
      localTreeColumn.setWidth(150);
    }
    this.c.setLayoutData(new GridData(1808));
    Iterator localIterator = this.a.getChildrenIterator();
    while (localIterator.hasNext())
      a((IElement)localIterator.next());
    this.c.addSelectionListener(new q(this));
    for (int j = 0; j < this.c.getColumnCount(); j++)
      this.c.getColumn(j).pack();
    return localComposite1;
  }

  private void a(IElement paramIElement)
  {
    TreeItem localTreeItem1 = new TreeItem(this.c, 0);
    localTreeItem1.setText(0, paramIElement.getDisplayName());
    localTreeItem1.setData(paramIElement);
    if ((paramIElement instanceof IBusinessObjectContainer))
    {
      Iterator localIterator = paramIElement.getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof IBusinessObjectEditen))
          continue;
        TreeItem localTreeItem2 = new TreeItem(localTreeItem1, 0);
        localTreeItem2.setData(localObject);
        localTreeItem2.setText(0, ((IBusinessObjectEditen)localObject).getDisplayName());
        localTreeItem2.setText(1, ((IBusinessObjectEditen)localObject).getValueName());
        localTreeItem2.setText(2, ((IBusinessObjectEditen)localObject).getValueType());
      }
      localTreeItem1.setExpanded(true);
    }
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem1 = this.c.getItems();
    this.b.clear();
    for (int i = 0; i < arrayOfTreeItem1.length; i++)
      if ((arrayOfTreeItem1[i].getData() instanceof IBusinessObjectContainer))
      {
        TreeItem[] arrayOfTreeItem2 = arrayOfTreeItem1[i].getItems();
        for (int j = 0; j < arrayOfTreeItem2.length; j++)
        {
          if ((!arrayOfTreeItem2[j].getChecked()) || (!(arrayOfTreeItem2[j].getData() instanceof IBusinessObjectEditen)))
            continue;
          this.b.add(arrayOfTreeItem2[j].getData());
        }
      }
      else
      {
        if (!arrayOfTreeItem1[i].getChecked())
          continue;
        this.b.add(arrayOfTreeItem1[i].getData());
      }
    super.okPressed();
  }

  public List a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.p
 * JD-Core Version:    0.6.0
 */