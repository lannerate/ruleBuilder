package org.agilemore.agilegrid;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.swt.graphics.Rectangle;

class f
  implements PropertyChangeListener
{
  f(e parame)
  {
  }

  public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent)
  {
    String str = paramPropertyChangeEvent.getPropertyName();
    Object localObject;
    if (str == "columnCount")
    {
      int i = ((Integer)paramPropertyChangeEvent.getNewValue()).intValue();
      localObject = this.a.A();
      if ((localObject != null) && (((G)localObject).d >= i))
        this.a.b(new G(this.a, ((G)localObject).c, i - 1));
      this.a.redraw();
    }
    else
    {
      Map localMap1;
      int k;
      if (str == "columnWidth")
      {
        localMap1 = (Map)paramPropertyChangeEvent.getNewValue();
        localObject = localMap1.keySet().iterator();
        k = -2147483648;
        while (((Iterator)localObject).hasNext())
        {
          k = ((Integer)((Iterator)localObject).next()).intValue();
          if ((k < this.a.f) || (k >= this.a.f + e.d(this.a)))
            continue;
          this.a.redraw();
          break;
        }
      }
      else
      {
        Rectangle localRectangle;
        if (str == "leftHeaderLabel")
        {
          localMap1 = (Map)paramPropertyChangeEvent.getNewValue();
          localObject = localMap1.keySet().iterator();
          k = -2147483648;
          while (((Iterator)localObject).hasNext())
          {
            k = ((Integer)((Iterator)localObject).next()).intValue();
            if ((k < this.a.e) || (k >= this.a.e + e.e(this.a)))
              continue;
            localRectangle = e.f(this.a);
            this.a.redraw(localRectangle.x, localRectangle.y, localRectangle.width, localRectangle.height, true);
            break;
          }
        }
        else if (str == "leftHeaderVisible")
        {
          this.a.redraw();
        }
        else if (str == "leftHeaderWidth")
        {
          this.a.redraw();
        }
        else if (str == "rowCount")
        {
          int j = ((Integer)paramPropertyChangeEvent.getNewValue()).intValue();
          localObject = this.a.A();
          if ((localObject != null) && (((G)localObject).c >= j))
            this.a.b(new G(this.a, j - 1, ((G)localObject).d));
          this.a.redraw();
        }
        else
        {
          Map localMap2;
          if (str == "rowHeight")
          {
            localMap2 = (Map)paramPropertyChangeEvent.getNewValue();
            localObject = localMap2.keySet().iterator();
            k = -2147483648;
            while (((Iterator)localObject).hasNext())
            {
              k = ((Integer)((Iterator)localObject).next()).intValue();
              if ((k < this.a.e) || (k >= this.a.e + e.e(this.a)))
                continue;
              this.a.redraw();
              break;
            }
          }
          else if (str == "topHeaderHeight")
          {
            this.a.redraw();
          }
          else if (str == "topHeaderLabel")
          {
            localMap2 = (Map)paramPropertyChangeEvent.getNewValue();
            localObject = localMap2.keySet().iterator();
            k = -2147483648;
            while (((Iterator)localObject).hasNext())
            {
              k = ((Integer)((Iterator)localObject).next()).intValue();
              if ((k < this.a.f) || (k >= this.a.f + e.d(this.a)))
                continue;
              localRectangle = e.g(this.a);
              this.a.redraw(localRectangle.x, localRectangle.y, localRectangle.width, localRectangle.height, true);
              break;
            }
          }
          else if (str == "topHeaderVisible")
          {
            this.a.redraw();
          }
          else if (str == "content")
          {
            localMap2 = (Map)paramPropertyChangeEvent.getNewValue();
            localObject = localMap2.keySet().iterator();
            ArrayList localArrayList = new ArrayList();
            while (((Iterator)localObject).hasNext())
              localArrayList.add((G)((Iterator)localObject).next());
            if (localArrayList.size() > 0)
              this.a.a((G[])localArrayList.toArray(new G[0]));
          }
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.f
 * JD-Core Version:    0.6.0
 */