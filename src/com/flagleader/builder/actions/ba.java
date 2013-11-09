package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.a.b;
import com.flagleader.repository.tree.a.c;
import java.io.File;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.TreeItem;

class ba
  implements DropTargetListener
{
  ba(aO paramaO)
  {
  }

  public void dragEnter(DropTargetEvent paramDropTargetEvent)
  {
    if (paramDropTargetEvent.detail == 16)
      paramDropTargetEvent.detail = 2;
  }

  public void dragOperationChanged(DropTargetEvent paramDropTargetEvent)
  {
    if (paramDropTargetEvent.detail == 16)
      paramDropTargetEvent.detail = 2;
  }

  public void dragOver(DropTargetEvent paramDropTargetEvent)
  {
    paramDropTargetEvent.feedback = 17;
  }

  public void drop(DropTargetEvent paramDropTargetEvent)
  {
    Object localObject1;
    Object localObject2;
    if (TextTransfer.getInstance().isSupportedType(paramDropTargetEvent.currentDataType))
    {
      if (paramDropTargetEvent.item == null)
        return;
      localObject1 = (TreeItem)paramDropTargetEvent.item;
      String str = (String)paramDropTargetEvent.data;
      localObject2 = (ITreeNode)((TreeItem)localObject1).getData();
      TreeItem localTreeItem = aO.a(this.a, null, str);
      if ((localTreeItem != null) && ((localTreeItem.getData() instanceof ITreeNode)) && (localObject2 != null) && (localObject2 != localTreeItem.getData()) && (((ITreeNode)localObject2).acceptNode((ITreeNode)localTreeItem.getData())))
      {
        ITreeNode localITreeNode;
        if (paramDropTargetEvent.detail == 2)
        {
          localITreeNode = (ITreeNode)((ITreeNode)localTreeItem.getData()).getParent();
          if (aO.d(this.a).showConfirm(ResourceTools.formatMessage("confirmmove.edit", new String[] { ((ITreeNode)localTreeItem.getData()).getDisplayName(), ((ITreeNode)localObject2).getDisplayName() })))
          {
            this.a.b.a(new b(localITreeNode, (ITreeNode)localTreeItem.getData(), localITreeNode.getElementPos((ITreeNode)localTreeItem.getData()), (ITreeNode)localObject2));
            if (((localTreeItem.getData() instanceof RulePackage)) && (!localObject2.equals(localITreeNode)))
            {
              if (!((ITreeNode)localObject2).isLocked())
              {
                ((ITreeNode)localObject2).addChildElement((ITreeNode)localTreeItem.getData());
                ((RulePackage)localTreeItem.getData()).setDirPath("");
                ((RulePackage)localTreeItem.getData()).setFilePathName("");
                ((ITreeNode)localObject2).setModified(true);
                ((IRulePackage)localTreeItem.getData()).setModified(true);
              }
            }
            else if (!((ITreeNode)localObject2).isLocked())
            {
              ((ITreeNode)localObject2).addChildElement((ITreeNode)localTreeItem.getData());
              ((ITreeNode)localObject2).setModified(true);
            }
            if ((localITreeNode != null) && ((localITreeNode instanceof ITreeNode)) && (!localITreeNode.isLocked()))
            {
              localITreeNode.removeChildElement((ITreeNode)localTreeItem.getData());
              localITreeNode.setModified(true);
              localITreeNode.updateTree();
            }
            ((ITreeNode)localObject2).updateTree();
          }
        }
        else if (paramDropTargetEvent.detail == 1)
        {
          localITreeNode = (ITreeNode)((ITreeNode)localTreeItem.getData()).deepClone();
          this.a.b.a(new c((ITreeNode)localObject2, localITreeNode));
          ((ITreeNode)localObject2).paste(localITreeNode);
          ((ITreeNode)localObject2).setModified(true);
          ((ITreeNode)localObject2).updateTree();
        }
      }
    }
    else if (FileTransfer.getInstance().isSupportedType(paramDropTargetEvent.currentDataType))
    {
      localObject1 = (String[])paramDropTargetEvent.data;
      if (paramDropTargetEvent.item == null)
      {
        for (int i = 0; i < localObject1.length; i++)
        {
          localObject2 = new File(localObject1[i]);
          aO.d(this.a).getRulesManager().a((File)localObject2);
        }
        this.a.i();
      }
    }
  }

  public void dragLeave(DropTargetEvent paramDropTargetEvent)
  {
  }

  public void dropAccept(DropTargetEvent paramDropTargetEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ba
 * JD-Core Version:    0.6.0
 */