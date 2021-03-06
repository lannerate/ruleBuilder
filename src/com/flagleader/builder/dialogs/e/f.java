package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.engine.Property;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class f extends r
{
  private List a = new ArrayList();
  private s b = new s();
  private BuilderManager c;
  private ITreeNode d;
  private Tree e;

  public f(BuilderManager paramBuilderManager, ITreeNode paramITreeNode)
  {
    super(paramBuilderManager.getShell());
    this.c = paramBuilderManager;
    this.d = paramITreeNode;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.ExportRuleSheetExcelDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(560, 460));
    this.e = this.b.a(localComposite2, 67618);
    this.e.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ExportRuleSheetExcelDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.ExportRuleSheetExcelDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.ExportRuleSheetExcelDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i = 0; i < arrayOfString3.length; i++)
      arrayOfInt[i] = Integer.parseInt(arrayOfString3[i]);
    for (i = 0; i < arrayOfString1.length; i++)
      arrayOfString1[i] = a(arrayOfString1[i] + ".ExportRuleSheetExcelDialog");
    this.b.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.e.setHeaderVisible(true);
    this.e.setLayoutData(new GridData(1808));
    this.e.addSelectionListener(new g(this));
    TreeItem localTreeItem = new TreeItem(this.e, 0);
    a(localTreeItem, this.d);
    return localComposite1;
  }

  private void a(TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
    Image localImage = ResourceTools.getIcon(paramITreeNode);
    if (localImage != null)
      paramTreeItem.setImage(localImage);
    paramTreeItem.setText(0, paramITreeNode.getDisplayName());
    paramTreeItem.setText(1, Property.getInstance().formatDatetime(new Date(paramITreeNode.getModifyTime())));
    paramTreeItem.setData(paramITreeNode);
    if ((paramITreeNode instanceof SheetTable))
      paramTreeItem.setChecked(true);
    Iterator localIterator = paramITreeNode.getChildNodes();
    while (localIterator.hasNext())
    {
      ITreeNode localITreeNode = (ITreeNode)localIterator.next();
      if ((!(localITreeNode instanceof Envionment)) && (!(localITreeNode instanceof DBModel)) && (!(localITreeNode instanceof BOContainerGroup)) && (!(localITreeNode instanceof SheetTable)))
        continue;
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      a(localTreeItem, localITreeNode);
    }
    paramTreeItem.setExpanded(true);
  }

  private void a(TreeItem paramTreeItem)
  {
    if ((paramTreeItem.getChecked()) && ((paramTreeItem.getData() instanceof SheetTable)))
      this.a.add(paramTreeItem.getData());
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      a(arrayOfTreeItem[i]);
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem = this.e.getItems();
    this.a.clear();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      a(arrayOfTreeItem[i]);
    HashMap localHashMap = new HashMap();
    for (int j = 0; j < this.a.size(); j++)
    {
      if (localHashMap.containsKey(((SheetTable)this.a.get(j)).getDisplayName()))
      {
        this.c.showError(ResourceTools.formatMessage("duplicatename.ExportRuleSheetExcelDialog", new String[] { ((SheetTable)this.a.get(j)).getDisplayName() }));
        return;
      }
      localHashMap.put(((SheetTable)this.a.get(j)).getDisplayName(), "");
    }
    super.okPressed();
  }

  public List a()
  {
    return this.a;
  }

  private void b(TreeItem paramTreeItem)
  {
    if (paramTreeItem.getParentItem() != null)
    {
      paramTreeItem.getParentItem().setChecked(false);
      b(paramTreeItem.getParentItem());
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.f
 * JD-Core Version:    0.6.0
 */