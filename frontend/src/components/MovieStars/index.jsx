import {ReactComponent as StarFull} from 'assets/img/starFull.svg';
import {ReactComponent as StarHalf} from 'assets/img/starHalft.svg';
import {ReactComponent as StarEmpty} from 'assets/img/startEmpty.svg';
import './styles.css'
function MovieStars() {
    return (
        <div className="dsmovie-stars-container">
            <StarFull />
            <StarFull />
            <StarFull />
            <StarHalf />
            <StarEmpty />
        </div>
    )
}
export default MovieStars;