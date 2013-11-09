package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.flow.RulePoolValue;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class V extends r
{
  private List i = new ArrayList();
  private Map j;
  private s k = new s();
  private BuilderManager l;
  private Envionment m;
  private Button n;
  private boolean o = false;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 1;
  private Tree p;

  public V(BuilderManager paramBuilderManager, List paramList, Envionment paramEnvionment)
  {
    super(null);
    this.l = paramBuilderManager;
    this.j = new HashMap();
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      RulePoolValue localRulePoolValue = (RulePoolValue)paramList.get(i1);
      IBusinessObject localIBusinessObject = localRulePoolValue.getSelected();
      if (localIBusinessObject == null)
        continue;
      this.j.put(localIBusinessObject, localIBusinessObject);
    }
    this.m = paramEnvionment;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.SelectRulesDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(500, 550));
    this.p = this.k.a(localComposite2, 67618);
    this.p.setLayoutData(new GridData(1808));
    this.p.setHeaderVisible(true);
    this.p.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadAssignVariablesDialog");
    while (this.p.getColumnCount() > 0)
      this.p.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i1 = 0; i1 < arrayOfString1.length; i1++)
      arrayOfString2[i1] = ResourceTools.getMessage(arrayOfString1[i1] + ".LoadAssignVariablesDialog");
    for (i1 = 0; i1 < arrayOfString2.length; i1++)
    {
      localObject1 = new TreeColumn(this.p, 8388608);
      ((TreeColumn)localObject1).setText(arrayOfString2[i1]);
      if (i1 == 0)
        ((TreeColumn)localObject1).setWidth(230);
      else
        ((TreeColumn)localObject1).setWidth(150);
    }
    this.p.setLayoutData(new GridData(1808));
    Iterator localIterator = this.m.getEnvionment().getTreeNodes();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (TreeValueNode)localIterator.next();
      localObject2 = new TreeItem(this.p, 0);
      a((TreeValueNode)localObject1, (TreeItem)localObject2);
    }
    Object localObject1 = this.m.getEnvionment().getAcceptElements(new W(this));
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IBusinessObjectContainer)((Iterator)localObject1).next();
      TreeItem localTreeItem = new TreeItem(this.p, 0);
      a((IBusinessObjectContainer)localObject2, localTreeItem);
    }
    return (Control)(Control)localComposite1;
  }

  private void a(TreeValueNode paramTreeValueNode, TreeItem paramTreeItem)
  {
    paramTreeItem.setText(0, paramTreeValueNode.getDisplayName());
    paramTreeItem.setData(paramTreeValueNode);
    if (this.j.get(paramTreeValueNode) != null)
      paramTreeItem.setChecked(true);
    List localList1 = paramTreeValueNode.getFields();
    for (int i1 = 0; i1 < localList1.size(); i1++)
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)localList1.get(i1);
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      localTreeItem.setData(localTreeAttribute);
      localTreeItem.setText(0, localTreeAttribute.getDisplayName());
      localTreeItem.setText(1, localTreeAttribute.getValueName());
      localTreeItem.setText(2, localTreeAttribute.getValueType());
      if (this.j.get(localTreeAttribute) == null)
        continue;
      localTreeItem.setChecked(true);
    }
    List localList2 = paramTreeValueNode.getAllNodes();
    for (int i2 = 0; i2 < localList2.size(); i2++)
    {
      if (!(localList2.get(i2) instanceof TreeValueNode))
        continue;
      a((TreeValueNode)localList2.get(i2), new TreeItem(paramTreeItem, 0));
    }
  }

  private void a(IBusinessObjectContainer paramIBusinessObjectContainer, TreeItem paramTreeItem)
  {
    paramTreeItem.setText(0, paramIBusinessObjectContainer.getDisplayName());
    paramTreeItem.setData(paramIBusinessObjectContainer);
    if (this.j.get(paramIBusinessObjectContainer) != null)
      paramTreeItem.setChecked(true);
    List localList = paramIBusinessObjectContainer.getAllEditens();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localList.get(i1);
      if (!(localIBusinessObjectEditen instanceof IVariableObject))
        continue;
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      localTreeItem.setData(localIBusinessObjectEditen);
      localTreeItem.setText(0, localIBusinessObjectEditen.getDisplayName());
      localTreeItem.setText(1, localIBusinessObjectEditen.getValueName());
      localTreeItem.setText(2, localIBusinessObjectEditen.getValueType());
      if (this.j.get(localIBusinessObjectEditen) == null)
        continue;
      localTreeItem.setChecked(true);
    }
  }

  private void a(TreeItem paramTreeItem)
  {
    if (paramTreeItem.getChecked())
    {
      this.i.add(paramTreeItem.getData());
    }
    else
    {
      TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
      for (int i1 = 0; i1 < arrayOfTreeItem.length; i1++)
        a(arrayOfTreeItem[i1]);
    }
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem = this.p.getItems();
    this.i.clear();
    for (int i1 = 0; i1 < arrayOfTreeItem.length; i1++)
      a(arrayOfTreeItem[i1]);
    super.okPressed();
  }

  public List a()
  {
    return this.i;
  }

  public boolean b()
  {
    return this.o;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.V
 * JD-Core Version:    0.6.0
 */