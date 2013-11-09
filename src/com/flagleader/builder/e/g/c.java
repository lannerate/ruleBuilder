package com.flagleader.builder.e.g;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class c extends WizardPage
{
  j a = null;
  private Tree b;

  public c(j paramj)
  {
    super("ReplaceMethodPage2");
    setTitle(a("title.ReplaceMethodPage2"));
    setDescription(a("describe.ReplaceMethodPage2"));
    this.a = paramj;
  }

  public void createControl(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(1));
    localComposite.setLayoutData(a(550, 400));
    this.b = new s().a(localComposite, ".ReplaceMethodPage2", 68386);
    Iterator localIterator = this.a.a().getEnvionment().getAcceptElements(new d(this));
    while (localIterator.hasNext())
    {
      IBusinessObjectContainer localIBusinessObjectContainer = (IBusinessObjectContainer)localIterator.next();
      TreeItem localTreeItem = new TreeItem(this.b, 0);
      b(localTreeItem, localIBusinessObjectContainer);
    }
    this.b.addSelectionListener(new e(this));
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
    paramTreeItem.setText(0, paramIElement.getDisplayName());
    a(paramTreeItem, paramIElement);
    paramTreeItem.setData(paramIElement);
    List localList = paramIElement.getChildrenList();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject;
      if ((localList.get(i) instanceof IBusinessObjectEditen))
      {
        localObject = (IBusinessObjectEditen)localList.get(i);
        TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
        localTreeItem.setData(localObject);
        localTreeItem.setText(0, ((IBusinessObjectEditen)localObject).getDisplayName());
        localTreeItem.setText(1, ((IBusinessObjectEditen)localObject).getValueName());
        localTreeItem.setText(2, ((IBusinessObjectEditen)localObject).getValueType());
        a(localTreeItem, (IElement)localObject);
        b(localTreeItem, (IElement)localObject);
      }
      else
      {
        if (!(localList.get(i) instanceof IBusinessObjectContainer))
          continue;
        localObject = new TreeItem(paramTreeItem, 0);
        b((TreeItem)localObject, (IBusinessObjectContainer)localList.get(i));
      }
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
 * Qualified Name:     com.flagleader.builder.e.g.c
 * JD-Core Version:    0.6.0
 */