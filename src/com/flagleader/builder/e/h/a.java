package com.flagleader.builder.e.h;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class a extends WizardPage
{
  j a = null;
  private Tree c;
  private List d = new ArrayList();
  HashMap b = new HashMap();

  public a(j paramj)
  {
    super("ReplaceVariablePage1");
    setTitle(a("title.ReplaceVariablePage1"));
    setDescription(a("describe.ReplaceVariablePage1"));
    this.a = paramj;
    Iterator localIterator = paramj.a().getRelateObjectMap(null).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IVariableObject))
        continue;
      this.d.add(localObject);
      this.b.put(((IVariableObject)localObject).getParent(), ((IVariableObject)localObject).getParent());
    }
  }

  public void createControl(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(1));
    localComposite.setLayoutData(a(550, 400));
    this.c = new s().a(localComposite, ".ReplaceVariablePage1", 68386);
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      TreeItem localTreeItem = new TreeItem(this.c, 0);
      b(localTreeItem, localIElement);
    }
    this.c.addSelectionListener(new b(this));
    setControl(localComposite);
  }

  private Image a(ITreeNode paramITreeNode)
  {
    return ResourceTools.getIcon(paramITreeNode);
  }

  private void a(TreeItem paramTreeItem, IElement paramIElement)
  {
    if ((paramIElement instanceof ITreeNode))
      paramTreeItem.setImage(a((ITreeNode)paramIElement));
    else if ((paramIElement.getParent() instanceof ITreeNode))
      paramTreeItem.setImage(a((ITreeNode)paramIElement.getParent()));
    else if ((paramIElement.getParent() instanceof ISubFunction))
      paramTreeItem.setImage(ResourceTools.getImage("classsubfunction.icon"));
    else if ((paramIElement.getParent() instanceof ISubVariable))
      paramTreeItem.setImage(ResourceTools.getImage("classsubvariable.icon"));
    else if ((paramIElement.getParent() instanceof IFunctionObject))
      paramTreeItem.setImage(ResourceTools.getImage("classfunction.icon"));
    else if ((paramIElement.getParent() instanceof IVariableObject))
      paramTreeItem.setImage(ResourceTools.getImage("classvariable.icon"));
  }

  private void b(TreeItem paramTreeItem, IElement paramIElement)
  {
    paramTreeItem.setText(0, paramIElement.getShowDisplayName());
    a(paramTreeItem, paramIElement);
    paramTreeItem.setData(paramIElement);
    List localList = this.d;
    for (int i = 0; i < localList.size(); i++)
    {
      if ((!(localList.get(i) instanceof IVariableObject)) || (!((IVariableObject)localList.get(i)).getParent().equals(paramIElement)))
        continue;
      IVariableObject localIVariableObject = (IVariableObject)localList.get(i);
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      localTreeItem.setData(localIVariableObject);
      localTreeItem.setText(0, localIVariableObject.getDisplayName());
      localTreeItem.setText(1, localIVariableObject.getValueName());
      localTreeItem.setText(2, localIVariableObject.getValueType());
    }
  }

  protected GridLayout a(int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    return localGridLayout;
  }

  protected String a(String paramString)
  {
    return ResourceTools.getMessage(paramString);
  }

  protected GridData a(int paramInt1, int paramInt2)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt1;
    localGridData.heightHint = paramInt2;
    return localGridData;
  }

  private void a()
  {
    b(null);
  }

  private void b(String paramString)
  {
    setErrorMessage(paramString);
    setPageComplete(paramString == null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.h.a
 * JD-Core Version:    0.6.0
 */